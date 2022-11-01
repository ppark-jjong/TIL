using System;
using System.Data;
using Oracle.DataAccess.Client;
namespace w9_dbex4_1941
{
    class Program
    {
        static void Main(string[] args)
        {
            string conStr = "User Id=scott; Password=tiger; Data Source=(DESCRIPTION = (ADDRESS = (PROTOCOL = TCP)(HOST = localhost)(PORT = 1521)) (CONNECT_DATA = (SERVER = DEDICATED) (SERVICE_NAME = xe) ) );";
            string commstr = "select  * from emp";
            Console.WriteLine("1. Connenction생성과Open");
            OracleConnection conn = new OracleConnection(conStr); 
            conn.Open();
            Console.WriteLine("2. OracleDataAdapter생성");
            OracleDataAdapter DBAdapter = new OracleDataAdapter(commstr, conn);
            //OracleDataAdapterDBAdapter= new OracleDataAdapter(commstr,  conStr); 
            Console.WriteLine("3. CommandBuilder생성");
            OracleCommandBuilder myCommandBuilder = new OracleCommandBuilder(DBAdapter);
            Console.WriteLine("4. DataSet생성");
            DataSet ds = new DataSet();
            Console.WriteLine("5. Adapter를통해서DataSet채우기"); 
            DBAdapter.Fill(ds); 
            Console.WriteLine("6. Connection 닫기"); 
            conn.Close();
        }
    }
}
