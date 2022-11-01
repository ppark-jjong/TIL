using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
/*프로퍼티 특징
   프로퍼티는 필드처럼 사용되지만, 메소드처럼 동작 되는 것이 특징이다.*/
namespace w3_
{
    class fraction
    {
        private int n;
        private int d;
        public int Nu
        {
            get { return n; }
            set { n = value; }
        }
        public int De
        {
            get { return d; }
            set { d = value; }
        }

        override public string ToString()
        {
            return (n + "/" + d);
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            fraction f = new fraction();
            int i;
            f.Nu = 1; //set Nu
            i = f.Nu + 1; //get Nu
            f.De = i; //set De
            Console.WriteLine(f.ToString());
        }
    }
}
