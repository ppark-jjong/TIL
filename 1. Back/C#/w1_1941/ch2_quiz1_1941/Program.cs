using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ch2_quiz1_1941
{
    class Program
    {
        static void Main(string[] args)
        {
            int i = 0;
            char c = ' ';
            Console.Write("Enter a digit and a character :");
            i = Console.Read() - 48;
            c = (char)Console.Read();
            Console.Write("i= " + i);
            Console.WriteLine(", c = " + c);
            Console.WriteLine("i= {0} , c = {1}", i, c );
        }
    }
}
