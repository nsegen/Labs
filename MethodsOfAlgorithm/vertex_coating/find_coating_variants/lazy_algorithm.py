def lazy_algorithm(graph):
    edges = {get_edge(v1, v2) for v1 in graph for v2 in graph[v1]}
    # print(graph)
    min_coating = set()
    while len(edges):
        edge = edges.pop()
        # print(edges, edge, min_coating)
        min_coating.add(edge[0])
        edges = set(filter(lambda e: e[0] != edge[0] and e[0] != edge[1] and e[1] != edge[0] and e[1] != edge[1], edges))
    return len(min_coating)


def get_edge(v1, v2):
    edge = [v1, v2]
    edge.sort()
    return edge[0], edge[1]

