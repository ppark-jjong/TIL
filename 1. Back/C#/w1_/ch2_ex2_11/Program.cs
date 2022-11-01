using System;

namespace ch2_ex2_11
{
    class Program
    {
        static void Main(string[] args)

        {

            int[][] arrayOfArray = new int[3][]; // 배열 선언
            int i, j;
            
            for (i = 0; i < arrayOfArray.Length; i++)
            {
                arrayOfArray[i] = new int[i + 3]; //가변형 배열 생성 중 (1열 3행 2열 4행 3열 5행)
            }

            for (i = 0; i < arrayOfArray.Length; i++)
            {
                for (j = 0; j < arrayOfArray[i].Length; j++)
                {
                    arrayOfArray[i][j] = i * arrayOfArray.Length + j; //가변형 배열에 값을 할당
                }
            }

            for (i = 0; i < arrayOfArray.Length; i++)
            {
                for (j = 0; j < arrayOfArray[i].Length; j++)
                {
                    Console.Write(" " + arrayOfArray[i][j]);//배열 출력
                }
                Console.WriteLine();
            }

        }
        /*출력 값
         0 1 2
         4 5 6 7
         10 11 12 13 14 15*/


    }
}
