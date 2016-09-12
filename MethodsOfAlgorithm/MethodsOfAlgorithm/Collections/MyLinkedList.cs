using System;

namespace MethodsOfAlgorithm.Collections
{

    class MyLinkedList<T> : IMyList<T>
    {

        private Node<T> head;
        public int Length { get; private set; }

        public MyLinkedList()
        {
            head = new Node<T>();
        }

        public IMyList<T> add(T data, int index)
        {
            if(index > Length || index < 0)
            {
                throw new IndexOutOfRangeException("Index more than length");
            } else if (isEmpty())
            {
                Length++;
                head.Data = data;
                return this;
            } else if (Length == index)
            {
                return addToEnd(data);
            } else if (index == 0)
            {
                return addToStart(data);
            }

            Node<T> tmpNode = head;

            while(index > 0)
            {
                tmpNode = tmpNode.Next;
                index--;
            }

            Node<T> newNode = new Node<T>()
            {
                Prev = tmpNode.Prev,
                Next = tmpNode,
                Data = data
            };

            newNode.Prev.Next = newNode;

            newNode.Next.Prev = newNode;

            Length++;

            return this;
        }

        public T get(int index)
        {
            if (index >= Length)
            {
                throw new IndexOutOfRangeException("Index more or equals than length");
            }
            Node<T> node = head;
            while(index > 0)
            {
                node = node.Next;
                index--;
            }
            return node.Data;
        }

        public IMyList<T> remove(int index)
        {
            Node<T> node = head;

            while (index > 0)
            {
                node = node.Next;
                index--;
            }

            node.Prev.Next = node.Next;
            node.Next.Prev = node.Prev;
          
            return this;
        }

        public bool isEmpty()
        {
            return Length == 0;
        }

        public IMyList<T> addToEnd(T data)
        {
            Node<T> node = head;
            while(node.Next != null)
            {
                node = node.Next;   
            }
            node.Next = new Node<T>
            {
                Prev = node,
                Data = data
            };
            Length++;
            return this;
        }

        public IMyList<T> addToStart(T data)
        {
            head.Prev = new Node<T>
            {
                Next = head,
                Data = data
            };
            Length++;
            head = head.Prev;
            return this;
        }
    }
}
