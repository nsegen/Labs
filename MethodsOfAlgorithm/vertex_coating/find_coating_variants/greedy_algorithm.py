
def greedy_algorithm(graph):
    result = 0
    for vertex in min_coating(graph):
        # print(vertex)
        result += 1
    return result


def min_coating(graph):
    vertex = max(graph, key=lambda i: len(graph[i]))
    while len(graph[vertex]) > 0:
        for v in graph[vertex]:
            graph[v].remove(vertex)
        graph[vertex] = []
        yield vertex
        vertex = max(graph, key=lambda i: len(graph[i]))
