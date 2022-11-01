using System;
/*프로퍼티 설정법
 필드처럼 사용되지만,
메소드처럼 동작*/
namespace ch_4ex4_14
{
    class Fraction
    {
        private int numerator;
        private int denominator;
        public int Numerator
        {
            get { return numerator; }
            set { numerator = value; }
        }
        public int Denominator
        {
            get { return denominator; }
            set { denominator = value; }
        }
        override public string ToString() { return (numerator + "/" + denominator); }
    }
    class PropertyApp
    {
        public static void Main()
        {
            Fraction f = new Fraction(); int i;
            f.Numerator = 1;   // invoke set-accessorin
            i = f.Numerator + 1; // invoke get-accessorin Numerator
            f.Denominator = i; // invoke set-accessorin Denominator
            Console.WriteLine(f.ToString());
        }
    }
}
