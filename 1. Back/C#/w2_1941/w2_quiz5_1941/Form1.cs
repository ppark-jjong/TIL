using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace w2_quiz5_1941
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        private double result;
        private string result2;

        
        private void button1_Click(object sender, EventArgs e)
        {
            double text1 = Convert.ToInt32(textBox1.Text);
            double text2 = Convert.ToInt32(textBox2.Text);
            result = text1 + text2;
            result2 = result.ToString();
            textBox3.Text = result2;

        }

        private void button2_Click(object sender, EventArgs e)
        {
            double text1 = Convert.ToInt32(textBox1.Text);
            double text2 = Convert.ToInt32(textBox2.Text);
            result = text1 - text2;
            result2 = result.ToString();
            textBox3.Text = result2;

        }

        private void button3_Click(object sender, EventArgs e)
        {
            double text1 = Convert.ToInt32(textBox1.Text);
            double text2 = Convert.ToInt32(textBox2.Text);
            result = text1 * text2;
            result2 = result.ToString();
            textBox3.Text = result2;

        }

        private void button4_Click(object sender, EventArgs e)
        {
            double text1 = Convert.ToInt32(textBox1.Text);
            double text2 = Convert.ToInt32(textBox2.Text);
            result = text1 / text2;
            result2 = result.ToString();
            textBox3.Text = result2;

        }

        private void button5_Click(object sender, EventArgs e)
        {
            double text1 = Convert.ToInt32(textBox1.Text);
            double text2 = Convert.ToInt32(textBox2.Text);
            result = text1 % text2;
            result2 = result.ToString();
            textBox3.Text = result2;

        }
        private void textBox3_TextChanged(object sender, EventArgs e)
        {
        }

    }
}
