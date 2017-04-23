def kruskal(graph):
    edges = {get_edge(v1, v2.popitem()) for v1 in graph for v2 in graph[v1]}
    edges = list(edges)
    edges.sort(key=lambda edge: -edge[2])
    vertexes = [{vertex} for vertex in graph.keys()]
    spanning_tree = {}
    while len(edges) > 1:
        edge = edges.pop()
        set1 = name_set(vertexes, edge[0])
        set2 = name_set(vertexes, edge[1])
        if set1 != set2:
            vertexes.remove(set1)
            vertexes.remove(set2)
            vertexes.append(set1 | set2)
            if edge[0] in spanning_tree:
                spanning_tree[edge[0]].append({edge[1]: edge[2]})
            else:
                spanning_tree[edge[0]] = [{edge[1]: edge[2]}]
            if edge[1] in spanning_tree:
                spanning_tree[edge[1]].append({edge[0]: edge[2]})
            else:
                spanning_tree[edge[1]] = [{edge[0]: edge[2]}]
    return spanning_tree


def name_set(vertexes, vertex):
    for vertex_set in vertexes:
        if vertex in vertex_set:
            return vertex_set


def get_edge(v1, v2_weight):
    v2, weight = v2_weight
    edge = [v1, v2_weight[0]]
    edge.sort()
    return edge[0], edge[1], weight
