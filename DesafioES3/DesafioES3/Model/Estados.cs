namespace DesafioES3.Model
{
    public class Estados
    {
        private int Codigo_Estado {get; set;}
        private string Nome { get; set;}

        public Estados() { 
            Codigo_Estado = 0;
            Nome = string.Empty;
        }

        public Estados(int codigo, string nome)
        {
            Codigo_Estado = codigo;
            Nome = nome;
        } 
    }
}
