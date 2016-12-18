from functools import reduce
from random import randint


class Individual:
    x = []

    def __init__(self, x):
        if any(number for number in x if number != 1 and number != 0):
            raise ValueError("Each coordinate must be equal 1 or 0")
        else:
            self._x = x

    @property
    def x(self):
        return self._x

    @x.setter
    def x(self, value):

        if any(number for number in value if number != 1 and number != 0):
            raise ValueError("Each coordinate must be equal 1 or 0")
        else:
            self._x = value


def fitness(individual):
    return reduce(lambda a,b: a + b, individual.x)


def recombination(i1, i2, size):
    if i1 == i2:
        raise ValueError("First individual and second individual are equals")
    p = randint(0, size-1)
    offspring1 = []
    offspring2 = []
    for i in range(size):
        if i <= p:
            offspring1.append(i1.x[i])
            offspring2.append(i2.x[i])
        else:
            offspring1.append(i2.x[i])
            offspring2.append(i1.x[i])
    return Individual(offspring1), Individual(offspring2)


def mutation(inds, size):

    p = randint(0, size-1)
    inds[0].x[p] = 1 if inds[0].x[p] == 0 else 0
    p = randint(0, size-1)
    inds[1].x[p] = 1 if inds[1].x[p] == 0 else 0

    return [inds[0], inds[1]]


def selection(population, n):

    population.sort(key=fitness, reverse=True)

    red = []

    return [population[i] for i in range(n)]


def check_population(population):

    eps = 0.00001
    for i in population:
        for j in population:
            if abs(1 - fitness(j)/fitness(i)) > eps:
                return False
    return True


def genetic_algorithm(population, n, size):
    print("_________________________________________________________")
    for i in range(n):
        print(population[i].x)
    print("__________________________________________________________")

    offsprings = []

    for ind in population:
        ind_two = population[randint(0, n - 1)]
        try:
            offsprings.extend(mutation(recombination(ind, ind_two, size), size))
        except ValueError:
            print("individual " + str(ind.x) + " are ignored")

    population.extend(offsprings)
    population = selection(population, n)

    if check_population(population):
        return population[0]
    else:
        return genetic_algorithm(population, n, size)


n = 10
size = 18
population = []

ind = Individual(population)

for i in range(n):
    x = [randint(0, 1) for i in range(size)]
    population.append(Individual(x))

# for ind in population:
#     print(ind.x)

result = genetic_algorithm(population, n, size)

print(str(result.x) + " " + str(fitness(result)))
