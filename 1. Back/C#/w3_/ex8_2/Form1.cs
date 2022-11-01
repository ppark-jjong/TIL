using System;
using System.Windows.Forms;
/*예제 8.2 체크박스*/
namespace ex8_2
{
    public partial class Form1 : Form
    {
        private string strTemp;
        private void UpdateLabel(string s, bool b)
        {
            if (b)
            {
                label1.Text += s;
            }
            else
            {
                strTemp = label1.Text;
                int i = strTemp.IndexOf(s);
                label1.Text = strTemp.Remove(i, s.Length);
            }
        }
        public Form1()
        {
            InitializeComponent();
        }
        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void checkbox1_CheckedChanged(object sender, EventArgs e)
        {
            UpdateLabel(checkBox1.Text, checkBox1.Checked);
        }
        private void checkbox2_CheckedChanged(object sender, EventArgs e)
        {
            UpdateLabel(checkBox2.Text, checkBox1.Checked);
        }
        private void checkbox3_CheckedChanged(object sender, EventArgs e)
        {
            UpdateLabel(checkBox3.Text, checkBox1.Checked);
        }
        private void checkbox4_CheckedChanged(object sender, EventArgs e)
        {
            UpdateLabel(checkBox4.Text, checkBox1.Checked);
        }



    }
}
