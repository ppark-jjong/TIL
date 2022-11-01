using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
/*형 변환
 기본 데이터 입력 자료형은 문자열로 a, b 에 할당 받은 문자열 값을 int, float 형으로 
변환 그 후 c는 묵시적 형변환으로 더한 값이 도출 된다*/
namespace ch2_quiz4
{
    class Program
    {
        static void Main(string[] args)
        {
            int a;
            float b, c;

            Console.Write("Enter a : ");
            a = int.Parse(Console.ReadLine());
            Console.Write("Enter b ; ");
            b = float.Parse(Console.ReadLine());
            c = a + b;
            Console.WriteLine("a  ={0}, b={1}, c={2}", a, b, c);
        }
    }
}
