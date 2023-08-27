using System;
using DesafioES3.DAO;

using System.ComponentModel.DataAnnotations.Schema;

namespace DesafioES3.Model
{
    [Table("estados")]
    public class Estados
    {
        private readonly string _connectionString;

        [Column("id_estado")]
        private int ID { get; set; }

        [Column("nome_estado")]
        private string Nome { get; set; }

        private EstadoDAO EstadoDAO = new EstadoDAO();

        public Estados(string connectionString)
        {
            ID = 0;
            Nome = string.Empty;
        }

        public int GetId()
        {
            return ID;
        }
        public void SetId(int ID)
        {
            this.ID = ID;
        }
        public string GetNome()
        {
            return Nome;
        }
        public void SetNome(string ID)
        {
            this.Nome = Nome;
        }


    }
}
