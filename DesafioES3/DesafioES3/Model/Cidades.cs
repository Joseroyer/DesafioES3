namespace DesafioES3.Model
{
    public class Cidades
    {
        private int Codigo_cidade { get; set; }
        private string Nome { get; set; }

        private Estados Estados { get; set; }

        public Cidades()
        {
               Codigo_cidade = 0;
               Nome = string.Empty;
               Estados = new Estados();
        }
        public Cidades(int codigo_cidade, string nome, Estados estados)
        {
            Codigo_cidade = codigo_cidade;
            Nome = nome;
            Estados = ;
        }
    }
}
