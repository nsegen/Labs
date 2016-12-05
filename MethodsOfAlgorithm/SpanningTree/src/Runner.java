import java.util.*;

/**
 * Created by nsegen on 3.12.16.
 */
public class Runner {

    public static void algorithmByPrim(int numberV, List<Edge> E, List<Edge> MST)
    {
        //неиспользованные ребра
        List<Edge> notUsedE = new ArrayList<>(E);
        //использованные вершины
        Set<Integer> usedV = new HashSet<>();
        //неиспользованные вершины
        Set<Integer> notUsedV = new HashSet<>();
        for (int i = 0; i < numberV; i++)
            notUsedV.add(i);
        //выбираем случайную начальную вершину
        Random rand = new Random();
        Integer v = rand.nextInt(numberV);
        usedV.add(v);
        notUsedV.remove(v);
        while (notUsedV.size() > 0)
        {
            int minE = -1; //номер наименьшего ребра
            //поиск наименьшего ребра
            for (int i = 0; i < notUsedE.size(); i++)
            {
                if (usedV.contains(notUsedE.get(i).v1) && notUsedV.contains(notUsedE.get(i).v2) ||
                        usedV.contains(notUsedE.get(i).v2) && notUsedV.contains(notUsedE.get(i).v1))
                {
                    if (minE != -1)
                    {
                        if (notUsedE.get(i).weight < notUsedE.get(minE).weight)
                            minE = i;
                    }
                    else
                        minE = i;
                }
            }
            //заносим новую вершину в список использованных и удаляем ее из списка неиспользованных
            if (usedV.contains(notUsedE.get(minE).v1))
            {
                usedV.add(notUsedE.get(minE).v2);
                notUsedV.remove(notUsedE.get(minE).v2);
            }
            else
            {
                usedV.add(notUsedE.get(minE).v1);
                notUsedV.remove(notUsedE.get(minE).v1);
            }
            //заносим новое ребро в дерево и удаляем его из списка неиспользованных
            MST.add(notUsedE.get(minE));
            notUsedE.remove(minE);
        }
    }

    public static void main(String[] args) {

        int n, m;

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите колличество вершин: ");
        n = sc.nextInt();
        System.out.println("Введите колличество ребер: ");
        m = sc.nextInt();

        List<Edge> E = new ArrayList<>(m);
        List<Edge> MST = new ArrayList<>();

        for(int i = 0; i < m; i++) {

            System.out.println("Введите ребро: ");
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int weight = sc.nextInt();

            E.add(new Edge(v1-1, v2-1, weight));

        }

        algorithmByPrim(n, E, MST);

        System.out.println(MST);

    }

}
