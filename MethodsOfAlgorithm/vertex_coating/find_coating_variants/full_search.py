def full_search(graph):
    return min_coating(graph, list(graph.keys()))


def min_coating(graph, vertexes):
    if not is_coating(graph, vertexes):
        return len(vertexes) + 1
    return min([min_coating(graph, get_sub_vertexes(vertexes, vertex)) for vertex in vertexes])


def is_coating(graph, vertexes):
    edges = {get_edge(v1, v2) for v1 in graph for v2 in graph[v1]}
    for edge in edges:
        for vertex in vertexes:
            if vertex == edge[0] or vertex == edge[1]:
                break
        else:
            return False
    return True


def get_edge(v1, v2):
    edge = [v1, v2]
    edge.sort()
    return edge[0], edge[1]


def get_sub_vertexes(vertexes, vertex):
    vertexes = vertexes.copy()
    vertexes.remove(vertex)
    return vertexes
