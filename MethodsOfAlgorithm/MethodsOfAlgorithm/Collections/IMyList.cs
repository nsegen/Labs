using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MethodsOfAlgorithm.Collections
{
    interface IMyList<T>
    {
        IMyList<T> add(T data, int index);
        IMyList<T> remove(int index);
        T get(int index);
        IMyList<T> addToEnd(T data);
        IMyList<T> addToStart(T data);
    }
}
