using Oracle.DataAccess.Client;
using System;
using System.Data;

namespace w9_dbex3_1941
{
    class Program
    {
        static void Main(string[] args)
        {
            string conStr = "User Id=scott; Password=tiger; " +
                "Data Source=(DESCRIPTION = (ADDRESS = (PROTOCOL = TCP)(HOST = localhost)(PORT = 1521)) " +
                "(CONNECT_DATA = (SERVER = DEDICATED) (SERVICE_NAME = xe)));";
            string query = "select  * from emp" ;
            Console.WriteLine("1. Connenction생성과 Open");
            OracleConnection conn = new OracleConnection(conStr); 
            conn.Open();
            Console.WriteLine("2. OracleDataAdapter생성");
            OracleDataAdapter adapter = new OracleDataAdapter();
            Console.WriteLine("3. Adapter에SelectCommand할당");
            adapter.SelectCommand = new OracleCommand(query, conn); 
            Console.WriteLine("4. DataSet생성");
            DataSet ds = new DataSet(); Console.WriteLine("5. Adapter를 통해서 DataSet채우기");
            adapter.Fill(ds); Console.WriteLine("6. Connection 닫기"); conn.Close();
        }
    }
}
