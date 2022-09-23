using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace w4_multiform_1941
{
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }

        public int LabelX
        {
            get { return Convert.ToInt32(textBox1.Text); }
            set { textBox1.Text = value.ToString(); }
        }

        public int LabelY
        {
            get { return Convert.ToInt32(textBox2.Text); }
            set { textBox2.Text = value.ToString(); }
        }

        public string LabelText
        {
            get { return textBox3.Text; }
            set { textBox3.Text = value; }

        }

        private void button2_Click(object sender, EventArgs e)
        {
            Close();
        }
        private void Form2_Load(object sender, EventArgs e)
        {

        }
    }
}
