def get_match(graph):

    vertexes = graph.keys()

    for v1 in vertexes:
        match = []
        temp_verts = [v for v in vertexes if v != v1]
        for v2 in temp_verts:
            match.append((v1, v2))
        print(match)


# def get_cost_of_match(graph, match):
