using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

/*자료형 중 값형에 해당하는 열거형 예제
    열거형이란 관련성이 깊은 상수들을 심볼릭한 명칭의 집합으로 정의 한것  */
enum SignFlag {black, yellow =3 , green, blue = 7, red}
namespace w1_ch2_quiz2
{
    class Program
    {
        static void Main(string[] args)
        {
            SignFlag s1;
            s1 = SignFlag.black;
            Console.WriteLine( "{0} = {1}", s1, (int)s1);
            s1 = SignFlag.yellow;
            Console.WriteLine("{0} = {1}", s1, (int)s1);

            Console.WriteLine("{0} = {1}", SignFlag.green, (int)SignFlag.green);
            Console.WriteLine("{0} = {1}", SignFlag.blue, (int)SignFlag.blue);
            Console.WriteLine("{0} = {1}", SignFlag.red, (int)SignFlag.red);

/*결과 값
 black = 0
yellow = 3
green = 4
blue = 7
red = 8
열거형은 자동 기호상수가 적용 되므로 일명 배열의 순서 값이 자동 할당된다
따라서 집합 선언에서 green과 red의 값이 자동 +1되는 것을 결과 값으로 볼수 있다.
 
 */
        }
    }
}
