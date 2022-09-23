using System;
using System.Windows.Forms;

namespace w4_multiform3_1941
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        private void OnApply(object sender, EventArgs e)
        {
            label1.Left = dlg.LabelX;
            label1.Top = dlg.LabelY;
            label1.Text = dlg.LabelText;
        }

        private Form2 dlg;
        
        private void button1_Click_1(object sender, EventArgs e)
        {
            if (dlg == null || dlg.IsDisposed)
            {
                dlg = new Form2();
                dlg.Owner = this;
                dlg.Apply += new EventHandler(OnApply);
                dlg.LabelX = label1.Left;
                dlg.LabelY = label1.Top;
                dlg.LabelText = label1.Text;
                dlg.Show();
            }
        }
    }
}
