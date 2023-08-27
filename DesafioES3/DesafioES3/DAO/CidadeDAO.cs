using DesafioES3.Model;
using Npgsql;

namespace DesafioES3.DAO
{
    public class CidadeDAO
    {
        string connectionString = "Host=localhost;Database=desafio_ES3;Username=postgres;Password=postgres123";
        public List<Cidades> GetAll()
        {
            List<Cidades> cidades = new List<Cidades>();

            using (NpgsqlConnection connection = new NpgsqlConnection(connectionString))
            {
                connection.Open();

                using (NpgsqlCommand command = new NpgsqlCommand("SELECT * FROM cidades", connection))
                {
                    using (NpgsqlDataReader reader = command.ExecuteReader())
                    {
                        while (reader.Read())
                        {
                            Cidades cidade = new Cidades();
                            cidade.SetId(Convert.ToInt32(reader["id_cidade"]));
                            cidade.SetNome(reader["nome_cidade"].ToString());
                            cidade.SetEstadoId(Convert.ToInt32(reader["codigo_estado"]));

                            cidades.Add(cidade);
                        }
                    }
                }
            }

            return cidades;
        }

        public void Save(Cidades cidade)
        {
            using (NpgsqlConnection connection = new NpgsqlConnection(connectionString))
            {
                connection.Open();

                using (NpgsqlCommand command = new NpgsqlCommand("INSERT INTO cidades (nome_cidade, EstadoId) VALUES (@Nome, @EstadoId)", connection))
                {
                    command.Parameters.AddWithValue("@Nome", cidade.GetNome());
                    command.Parameters.AddWithValue("@EstadoId", cidade.GetEstado());

                    command.ExecuteNonQuery();
                }
            }
        }

        public void Update(Cidades cidade)
        {
            using (NpgsqlConnection connection = new NpgsqlConnection(connectionString))
            {
                connection.Open();

                using (NpgsqlCommand command = new NpgsqlCommand("UPDATE Cidades SET Nome = @Nome, EstadoId = @EstadoId WHERE Id = @Id", connection))
                {
                    command.Parameters.AddWithValue("@Nome", cidade.Nome);
                    command.Parameters.AddWithValue("@EstadoId", cidade.EstadoId);
                    command.Parameters.AddWithValue("@Id", cidade.Id);

                    command.ExecuteNonQuery();
                }
            }
        }
        public void Delete(int id)
        {
            using (NpgsqlConnection connection = new NpgsqlConnection(connectionString))
            {
                connection.Open();

                using (NpgsqlCommand command = new NpgsqlCommand("DELETE FROM Cidades WHERE Id = @Id", connection))
                {
                    command.Parameters.AddWithValue("@Id", id);

                    command.ExecuteNonQuery();
                }
            }
        }
    }
}
