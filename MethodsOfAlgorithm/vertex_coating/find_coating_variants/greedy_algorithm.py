
def greedy_algorithm(graph):
    return len(min_coating(graph))


def min_coating(graph):
    vertex = max(graph, key=lambda i: len(graph[i]))
    while len(graph[vertex]) > 0:
        for v in graph[vertex]:
            graph[v].remove(vertex)
        graph[vertex] = []
        yield vertex
        vertex = max(graph, key=lambda i: len(graph[i]))
