using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MethodsOfAlgorithm.Collections;

namespace MethodsOfAlgorithm
{
    class Program
    {
        static void Main(string[] args)
        {
            IMyList<int> list = new MyLinkedList<int>();
            list.add(1,0);
            list.add(5, 0);
            list.add(10, 1);
            list.add(2, 3);
            Console.WriteLine(list.get(((MyLinkedList<int>)list).Length));
            Console.Read();
        }
    }
}
