using Oracle.DataAccess.Client;
using System;

namespace w7_dbex2_1941
{
    class Program
    {
        static void Main(string[] args)
        {
            

            string query = "select ename from emp";
            OracleConnection conn = new OracleConnection(ConStr);
            conn.Open();
            OracleCommand comm = new OracleCommand(query, conn);
            OracleDataReader sr = comm.ExecuteReader();
            while (sr.Read()) { Console.Write(sr.GetString(0) + "|"); }
            sr.Close(); conn.Close();
        }
    }
}
