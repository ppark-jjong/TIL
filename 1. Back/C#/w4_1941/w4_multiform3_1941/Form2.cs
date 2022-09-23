using System;
using System.Windows.Forms;

namespace w4_multiform3_1941
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
        public string LabelText { get { return textBox3.Text; } set { textBox3.Text = value; } }
        public event EventHandler Apply;
        private void button1_Click(object sender, EventArgs e)
        {
            if (Apply != null)
            {
                Apply(this, new EventArgs()); //매개변수타입이같아야함!}}
                                              //private void button2_Click(object sender, EventArgse){Dispose();
            }
        }
    }
}