
namespace w9_ADOForm
{
    partial class Form1
    {
        /// <summary>
        /// 필수 디자이너 변수입니다.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 사용 중인 모든 리소스를 정리합니다.
        /// </summary>
        /// <param name="disposing">관리되는 리소스를 삭제해야 하면 true이고, 그렇지 않으면 false입니다.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form 디자이너에서 생성한 코드

        /// <summary>
        /// 디자이너 지원에 필요한 메서드입니다. 
        /// 이 메서드의 내용을 코드 편집기로 수정하지 마세요.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.AppendBtn = new System.Windows.Forms.Button();
            this.txtid = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.txtName = new System.Windows.Forms.TextBox();
            this.txtPhone = new System.Windows.Forms.TextBox();
            this.txtMail = new System.Windows.Forms.TextBox();
            this.UpdateBtn = new System.Windows.Forms.Button();
            this.DeleteBtn = new System.Windows.Forms.Button();
            this.DBGrid = new System.Windows.Forms.DataGridView();
            this.DAOpenBtn = new System.Windows.Forms.Button();
            this.CCBtn = new System.Windows.Forms.Button();
            this.DRBtn = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.DBGrid)).BeginInit();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("굴림", 10.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.label1.Location = new System.Drawing.Point(116, 21);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(24, 19);
            this.label1.TabIndex = 0;
            this.label1.Text = "Id";
            // 
            // AppendBtn
            // 
            this.AppendBtn.Location = new System.Drawing.Point(404, 96);
            this.AppendBtn.Name = "AppendBtn";
            this.AppendBtn.Size = new System.Drawing.Size(113, 36);
            this.AppendBtn.TabIndex = 1;
            this.AppendBtn.Text = "AppendBtn";
            this.AppendBtn.UseVisualStyleBackColor = true;
            this.AppendBtn.Click += new System.EventHandler(this.AppendBtn_Click);
            // 
            // txtid
            // 
            this.txtid.Location = new System.Drawing.Point(166, 20);
            this.txtid.Name = "txtid";
            this.txtid.Size = new System.Drawing.Size(161, 25);
            this.txtid.TabIndex = 2;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("굴림", 10.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.label2.Location = new System.Drawing.Point(97, 70);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(49, 19);
            this.label2.TabIndex = 0;
            this.label2.Text = "이름";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("굴림", 10.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.label3.Location = new System.Drawing.Point(57, 113);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(89, 19);
            this.label3.TabIndex = 0;
            this.label3.Text = "전화번호";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("굴림", 10.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(129)));
            this.label4.Location = new System.Drawing.Point(80, 157);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(66, 19);
            this.label4.TabIndex = 0;
            this.label4.Text = "E-Mail";
            // 
            // txtName
            // 
            this.txtName.Location = new System.Drawing.Point(166, 70);
            this.txtName.Name = "txtName";
            this.txtName.Size = new System.Drawing.Size(161, 25);
            this.txtName.TabIndex = 2;
            // 
            // txtPhone
            // 
            this.txtPhone.Location = new System.Drawing.Point(166, 113);
            this.txtPhone.Name = "txtPhone";
            this.txtPhone.Size = new System.Drawing.Size(161, 25);
            this.txtPhone.TabIndex = 2;
            // 
            // txtMail
            // 
            this.txtMail.Location = new System.Drawing.Point(166, 157);
            this.txtMail.Name = "txtMail";
            this.txtMail.Size = new System.Drawing.Size(161, 25);
            this.txtMail.TabIndex = 2;
            // 
            // UpdateBtn
            // 
            this.UpdateBtn.Location = new System.Drawing.Point(532, 96);
            this.UpdateBtn.Name = "UpdateBtn";
            this.UpdateBtn.Size = new System.Drawing.Size(113, 36);
            this.UpdateBtn.TabIndex = 1;
            this.UpdateBtn.Text = "UpdateBtn";
            this.UpdateBtn.UseVisualStyleBackColor = true;
            this.UpdateBtn.Click += new System.EventHandler(this.UpdateBtn_Click);
            // 
            // DeleteBtn
            // 
            this.DeleteBtn.Location = new System.Drawing.Point(662, 96);
            this.DeleteBtn.Name = "DeleteBtn";
            this.DeleteBtn.Size = new System.Drawing.Size(113, 36);
            this.DeleteBtn.TabIndex = 1;
            this.DeleteBtn.Text = "DeleteBtn";
            this.DeleteBtn.UseVisualStyleBackColor = true;
            this.DeleteBtn.Click += new System.EventHandler(this.DeleteBtn_Click);
            // 
            // DBGrid
            // 
            this.DBGrid.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.DBGrid.Location = new System.Drawing.Point(84, 208);
            this.DBGrid.Name = "DBGrid";
            this.DBGrid.RowHeadersWidth = 51;
            this.DBGrid.RowTemplate.Height = 27;
            this.DBGrid.Size = new System.Drawing.Size(670, 150);
            this.DBGrid.TabIndex = 3;
            this.DBGrid.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.DBGrid_CellContentClick);
            // 
            // DAOpenBtn
            // 
            this.DAOpenBtn.Location = new System.Drawing.Point(244, 378);
            this.DAOpenBtn.Name = "DAOpenBtn";
            this.DAOpenBtn.Size = new System.Drawing.Size(113, 36);
            this.DAOpenBtn.TabIndex = 1;
            this.DAOpenBtn.Text = "DAOpenBtn";
            this.DAOpenBtn.UseVisualStyleBackColor = true;
            this.DAOpenBtn.Click += new System.EventHandler(this.DAOpenBtn_Click);
            // 
            // CCBtn
            // 
            this.CCBtn.Location = new System.Drawing.Point(372, 378);
            this.CCBtn.Name = "CCBtn";
            this.CCBtn.Size = new System.Drawing.Size(113, 36);
            this.CCBtn.TabIndex = 1;
            this.CCBtn.Text = "CCBtn";
            this.CCBtn.UseVisualStyleBackColor = true;
            this.CCBtn.Click += new System.EventHandler(this.CCBtn_Click);
            // 
            // DRBtn
            // 
            this.DRBtn.Location = new System.Drawing.Point(502, 378);
            this.DRBtn.Name = "DRBtn";
            this.DRBtn.Size = new System.Drawing.Size(113, 36);
            this.DRBtn.TabIndex = 1;
            this.DRBtn.Text = "DRBtn";
            this.DRBtn.UseVisualStyleBackColor = true;
            this.DRBtn.Click += new System.EventHandler(this.DRBtn_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.DBGrid);
            this.Controls.Add(this.txtMail);
            this.Controls.Add(this.txtPhone);
            this.Controls.Add(this.txtName);
            this.Controls.Add(this.txtid);
            this.Controls.Add(this.DRBtn);
            this.Controls.Add(this.DeleteBtn);
            this.Controls.Add(this.CCBtn);
            this.Controls.Add(this.UpdateBtn);
            this.Controls.Add(this.DAOpenBtn);
            this.Controls.Add(this.AppendBtn);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Name = "Form1";
            this.Text = "Form1";
            ((System.ComponentModel.ISupportInitialize)(this.DBGrid)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button AppendBtn;
        private System.Windows.Forms.TextBox txtid;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox txtName;
        private System.Windows.Forms.TextBox txtPhone;
        private System.Windows.Forms.TextBox txtMail;
        private System.Windows.Forms.Button UpdateBtn;
        private System.Windows.Forms.Button DeleteBtn;
        private System.Windows.Forms.DataGridView DBGrid;
        private System.Windows.Forms.Button DAOpenBtn;
        private System.Windows.Forms.Button CCBtn;
        private System.Windows.Forms.Button DRBtn;
    }
}

