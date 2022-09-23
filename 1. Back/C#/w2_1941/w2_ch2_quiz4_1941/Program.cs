using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace w2_ch2_quiz4_1941
{
    class Program
    {
        static void Main(string[] args)
        {
            int a;
            float b, c;
            Console.Write("Enter : ");
            a = int.Parse(Console.ReadLine());
            Console.Write("Enter : ");
            b = float.Parse(Console.ReadLine());
            c = a + b;
            Console.WriteLine("a = {0}, b = {1}, c = {2}", a, b, c);
        }
    }
}
