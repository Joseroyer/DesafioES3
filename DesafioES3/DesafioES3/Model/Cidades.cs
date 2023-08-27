using DesafioES3.DAO;
using System.ComponentModel.DataAnnotations.Schema;

namespace DesafioES3.Model
{
    [Table("cidades")]
    public class Cidades
    {
        private readonly string _connectionString;

        [Column("id_cidade")]
        private int ID { get; set; }
        [Column("nome_cidade")]

        private string Nome { get; set; }

        private Estados Estados { get; set; }
        [ForeignKey("codigo_estado")]
        private int  codigo_estado { get; set; }

        private EstadoDAO estadoDAO = new EstadoDAO();

        public Cidades() { 
            ID = 0;
            Nome = string.Empty;
        }
        public Cidades(int ID, string nome, Estados estados)
        {
            this.ID = ID;
            Nome = nome;
            Estados = Estados;
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

        public void SetNome(string nome)
        {
            Nome = nome;
        }

        public Estados GetEstado()
        {
            return Estados;
        }

        public void SetEstado(Estados estado)
        {
            Estados = estado;
        }
        public int GetEstadoId()
        {
            return EstadoId;
        }

        public void SetEstadoId(int estadoId)
        {
            EstadoId = estadoId;
        }

    }
}
