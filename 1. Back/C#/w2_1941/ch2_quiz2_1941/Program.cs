using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
enum SignFlag { black, yellow = 3,green, blue = 7,red }
namespace ch2_quiz2_1941
{
    class Program
    {
        static void Main(string[] args)
        {
            SignFlag s1;
            s1 = SignFlag.black;
            Console.WriteLine("{0}={1}", s1, (int)s1); 
            s1 = SignFlag.yellow; 
            Console.WriteLine("{0}={1}", s1, (int)s1);
            Console.WriteLine("{0}={1}", SignFlag.green, (int)SignFlag.green);
            Console.WriteLine("{0}={1}", SignFlag.blue, (int)SignFlag.blue);
            Console.WriteLine("{0}={1}", SignFlag.red, (int)SignFlag.red);
        }
    }
}
