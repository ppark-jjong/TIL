using Oracle.DataAccess.Client;
using System;
using System.Data;
using System.Windows.Forms;

namespace w9_ADOForm
{
    public partial class Form1 : Form
    {
        private int SelectedRowIndex;
        public Form1()
        {
            InitializeComponent();
        }

        private void DAOpenBtn_Click(object sender, EventArgs e)
        {
            try
            {
                string connectionString = "User Id=park1; Password=1111; Data Source=(DESCRIPTION = (ADDRESS = (PROTOCOL = TCP)(HOST = localhost)(PORT = 1521)) (CONNECT_DATA = (SERVER = DEDICATED) (SERVICE_NAME = xe) ) );";
                string commandString = "select * from phone";
                OracleDataAdapter DBAdapter = new OracleDataAdapter(commandString, connectionString);
                DataSet DS = new DataSet(); DBAdapter.Fill(DS, "phone");
                DBGrid.DataSource = DS.Tables["phone"].DefaultView;
            }
            catch (DataException DE) { MessageBox.Show(DE.Message); }
            catch (Exception DE) { MessageBox.Show(DE.Message); }
        }

        private void CCBtn_Click(object sender, EventArgs e)
        {
            try
            {
                string connectionString = "User Id=park1; Password=1111; Data Source=(DESCRIPTION = (ADDRESS = (PROTOCOL = TCP)(HOST = localhost)(PORT = 1521)) (CONNECT_DATA = (SERVER = DEDICATED) (SERVICE_NAME = xe) ) );";
                OracleConnection myConnection = new OracleConnection(connectionString);
                string commandString = "select * from Phone";
                OracleCommand myCommand = new OracleCommand();
                myCommand.Connection = myConnection;
                myCommand.CommandText = commandString; OracleDataAdapter DBAdapter = new OracleDataAdapter();
                DBAdapter.SelectCommand = myCommand;
                DataSet DS = new DataSet(); DBAdapter.Fill(DS, "Phone");
                DBGrid.DataSource = DS.Tables["Phone"].DefaultView;
            }
            catch (DataException DE) { MessageBox.Show(DE.Message); }
            catch (Exception DE)
            {
                MessageBox.Show(DE.Message);
            }
        }


        private void DRBtn_Click(object sender, EventArgs e)
        {
            try
            {
                string connectionString = "User Id=park1; Password=1111; Data Source=(DESCRIPTION = (ADDRESS = (PROTOCOL = TCP)(HOST = localhost)(PORT = 1521)) (CONNECT_DATA = (SERVER = DEDICATED) (SERVICE_NAME = xe) ) );";
                OracleConnection myConnection = new OracleConnection(connectionString);
                string commandString = "select * from phone"; OracleCommand myCommand = new OracleCommand();
                myCommand.Connection = myConnection;
                myCommand.CommandText = commandString; myConnection.Open();
                OracleDataReader myReader; myReader = myCommand.ExecuteReader();
                string ResultMessage = "";
                while (myReader.Read())
                {
                    ResultMessage = myReader.GetString(1) + ", " + myReader.GetString(2);
                    MessageBox.Show(ResultMessage);
                }
                myReader.Close(); myConnection.Close();
            }

            catch (DataException DE) { MessageBox.Show(DE.Message); }
            catch (Exception DE)
            {
                MessageBox.Show(DE.Message);
            }

        }

        private void AppendBtn_Click(object sender, EventArgs e)
        {
            try
            {
                string connectionString = "User Id=park1; Password=1111; Data Source=(DESCRIPTION = (ADDRESS = (PROTOCOL = TCP)(HOST = localhost)(PORT = 1521)) (CONNECT_DATA = (SERVER = DEDICATED) (SERVICE_NAME = xe) ) );";
                string commandString = "select * from Phone";
                OracleDataAdapter DBAdapter = new OracleDataAdapter(commandString, connectionString);
                OracleCommandBuilder mycommandBuilder = new OracleCommandBuilder(DBAdapter);
                DataSet DS = new DataSet(); DBAdapter.Fill(DS, "Phone"); DataTable phoneTable = DS.Tables["Phone"];
                DataRow newRow = phoneTable.NewRow();
                newRow["id"] = Convert.ToInt32(txtid.Text);
                newRow["PName"] = txtName.Text; newRow["Phone"] = txtPhone.Text; newRow["Email"] = txtMail.Text;
                phoneTable.Rows.Add(newRow); DBAdapter.Update(DS, "Phone"); DBGrid.DataSource = DS.Tables["Phone"].DefaultView;
            }
            catch (DataException DE) { MessageBox.Show(DE.Message); }
            catch (Exception DE) { MessageBox.Show(DE.Message); }
        }

        private void UpdateBtn_Click(object sender, EventArgs e)
        {
            try
            {
                string connectionString = "User Id=park1; Password=1111; Data Source=(DESCRIPTION = (ADDRESS = (PROTOCOL = TCP)(HOST = localhost)(PORT = 1521)) (CONNECT_DATA = (SERVER = DEDICATED) (SERVICE_NAME = xe) ) );";
                string commandString = "select * from Phone";
                OracleDataAdapter DBAdapter = new OracleDataAdapter(commandString, connectionString);
                OracleCommandBuilder myCommandBuilder = new OracleCommandBuilder(DBAdapter);
                DataSet DS = new DataSet("Phone"); DBAdapter.Fill(DS, "Phone");
                DataTable phoneTable = DS.Tables["Phone"];
                DataColumn[] PrimaryKey = new DataColumn[1];
                PrimaryKey[0] = phoneTable.Columns["id"]; phoneTable.PrimaryKey = PrimaryKey;
                DataRow currRow = phoneTable.Rows.Find(SelectedRowIndex); currRow.BeginEdit(); currRow["id"] = txtid.Text;
                currRow["PName"] = txtName.Text; currRow["Phone"] = txtPhone.Text; currRow["EMail"] = txtMail.Text; currRow.EndEdit();
                DataSet UpdatedSet = DS.GetChanges(DataRowState.Modified);
                if (UpdatedSet.HasErrors) { MessageBox.Show("변경된데이터에문제가있습니다."); }
                else { DBAdapter.Update(UpdatedSet, "Phone"); DS.AcceptChanges(); }
                DBGrid.DataSource = DS.Tables["Phone"].DefaultView;
            }
            catch (DataException DE) { MessageBox.Show(DE.Message); }
            catch (Exception DE) { MessageBox.Show(DE.Message); }
        }

        private void DeleteBtn_Click(object sender, EventArgs e)
        {
            try
            {
                string connectionString = "User Id=park1; Password=1111; Data Source=(DESCRIPTION = (ADDRESS = (PROTOCOL = TCP)(HOST = localhost)(PORT = 1521)) (CONNECT_DATA = (SERVER = DEDICATED) (SERVICE_NAME = xe) ) );";
                string commandString = "select * from Phone";
                OracleDataAdapter DBAdapter = new OracleDataAdapter(commandString, connectionString);
                OracleCommandBuilder myCommandBuilder = new OracleCommandBuilder(DBAdapter);
                DataSet DS = new DataSet("Phone"); DBAdapter.Fill(DS, "Phone");
                DataTable phoneTable = DS.Tables["Phone"]; DataColumn[] PrimaryKey = new DataColumn[1];
                PrimaryKey[0] = phoneTable.Columns["id"]; phoneTable.PrimaryKey = PrimaryKey;
                DataRow currRow = phoneTable.Rows.Find(SelectedRowIndex); currRow.Delete();
                DBAdapter.Update(DS.GetChanges(DataRowState.Deleted), "Phone"); DBGrid.DataSource = DS.Tables["Phone"].DefaultView;
            }
            catch (DataException DE) { MessageBox.Show(DE.Message); }
            catch (Exception DE) { MessageBox.Show(DE.Message); }
        }

        private void DBGrid_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }
        private void DBGrid_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            try
            {
                string connectionString = "User Id=park1; Password=1111; Data Source=(DESCRIPTION = (ADDRESS = (PROTOCOL = TCP)(HOST = localhost)(PORT = 1521)) (CONNECT_DATA = (SERVER = DEDICATED) (SERVICE_NAME = xe) ) );"; string commandString = "select * from Phone";
                OracleDataAdapter DBAdapter = new OracleDataAdapter(commandString, connectionString); DataSet DS = new DataSet();
                DBAdapter.Fill(DS, "Phone"); DataTable phoneTable = DS.Tables["Phone"]; if (e.RowIndex < 0) { return; }
                else if (e.RowIndex > phoneTable.Rows.Count - 1) { MessageBox.Show("해당하는데이터가존재하지않습니다."); return; }
                DataRow currRow = phoneTable.Rows[e.RowIndex]; txtid.Text = currRow["id"].ToString(); txtName.Text = currRow["PName"].ToString(); txtPhone.Text = currRow["Phone"].ToString(); txtMail.Text = currRow["EMail"].ToString(); SelectedRowIndex = Convert.ToInt32(currRow["id"]);
            }
            catch (DataException DE) { MessageBox.Show(DE.Message); }
            catch (Exception DE)
            {
                MessageBox.Show(DE.Message);
            }

        }
    }
}

