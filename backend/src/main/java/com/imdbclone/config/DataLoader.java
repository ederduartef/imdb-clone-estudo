package com.imdbclone.config;

import com.imdbclone.model.Movie;
import com.imdbclone.model.User;
import com.imdbclone.repository.MovieRepository;
import com.imdbclone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    
    @Autowired
    private MovieRepository movieRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public void run(String... args) throws Exception {
        // Criar usuário de teste
        if (!userRepository.existsByUsername("admin")) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setEmail("admin@imdbclone.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole("ADMIN");
            userRepository.save(admin);
        }
        
        if (!userRepository.existsByUsername("user")) {
            User user = new User();
            user.setUsername("user");
            user.setEmail("user@imdbclone.com");
            user.setPassword(passwordEncoder.encode("user123"));
            userRepository.save(user);
        }
        
        // Criar filmes de exemplo
        if (movieRepository.count() == 0) {
            // Filmes originais
            Movie movie1 = new Movie(
                "O Poderoso Chefão",
                "Uma família mafiosa luta para estabelecer sua supremacia nos Estados Unidos depois da Segunda Guerra Mundial.",
                "https://via.placeholder.com/300x450/000000/FFFFFF?text=O+Poderoso+Chefão",
                1972,
                "Francis Ford Coppola",
                "Drama"
            );
            movieRepository.save(movie1);
            
            Movie movie2 = new Movie(
                "Pulp Fiction",
                "As vidas de dois assassinos da máfia, um boxeador, a esposa de um gângster e dois bandidos se entrelaçam em quatro histórias de violência e redenção.",
                "https://via.placeholder.com/300x450/000000/FFFFFF?text=Pulp+Fiction",
                1994,
                "Quentin Tarantino",
                "Crime"
            );
            movieRepository.save(movie2);
            
            Movie movie3 = new Movie(
                "Interestelar",
                "Uma equipe de exploradores viaja através de um buraco de minhoca no espaço na tentativa de garantir a sobrevivência da humanidade.",
                "https://via.placeholder.com/300x450/000000/FFFFFF?text=Interestelar",
                2014,
                "Christopher Nolan",
                "Ficção Científica"
            );
            movieRepository.save(movie3);

            // Novos filmes adicionados
            Movie movie4 = new Movie(
                "Forrest Gump",
                "A história de um homem simples que viveu momentos extraordinários na história dos Estados Unidos.",
                "https://via.placeholder.com/300x450/000000/FFFFFF?text=Forrest+Gump",
                1994,
                "Robert Zemeckis",
                "Drama"
            );
            movieRepository.save(movie4);

            Movie movie5 = new Movie(
                "Matrix",
                "Um programador descobre que a realidade como conhecemos é uma simulação criada por máquinas.",
                "https://via.placeholder.com/300x450/000000/FFFFFF?text=Matrix",
                1999,
                "Lana e Lilly Wachowski",
                "Ficção Científica"
            );
            movieRepository.save(movie5);

            Movie movie6 = new Movie(
                "Titanic",
                "A história de amor entre um artista pobre e uma jovem rica a bordo do navio que afundou em 1912.",
                "https://via.placeholder.com/300x450/000000/FFFFFF?text=Titanic",
                1997,
                "James Cameron",
                "Romance"
            );
            movieRepository.save(movie6);

            Movie movie7 = new Movie(
                "O Senhor dos Anéis: A Sociedade do Anel",
                "Um hobbit recebe a missão de destruir um anel poderoso que pode destruir o mundo.",
                "https://via.placeholder.com/300x450/000000/FFFFFF?text=O+Senhor+dos+Anéis",
                2001,
                "Peter Jackson",
                "Fantasia"
            );
            movieRepository.save(movie7);

            Movie movie8 = new Movie(
                "Jurassic Park",
                "Um parque temático com dinossauros clonados sai do controle quando os animais escapam.",
                "https://via.placeholder.com/300x450/000000/FFFFFF?text=Jurassic+Park",
                1993,
                "Steven Spielberg",
                "Aventura"
            );
            movieRepository.save(movie8);

            Movie movie9 = new Movie(
                "O Rei Leão",
                "Um jovem leão deve enfrentar seu passado e assumir seu destino como rei da savana.",
                "https://via.placeholder.com/300x450/000000/FFFFFF?text=O+Rei+Leão",
                1994,
                "Roger Allers e Rob Minkoff",
                "Animação"
            );
            movieRepository.save(movie9);

            Movie movie10 = new Movie(
                "Avatar",
                "Um soldado paraplégico é enviado para um planeta alienígena e se apaixona por uma nativa.",
                "https://via.placeholder.com/300x450/000000/FFFFFF?text=Avatar",
                2009,
                "James Cameron",
                "Ficção Científica"
            );
            movieRepository.save(movie10);

            Movie movie11 = new Movie(
                "Vingadores: Ultimato",
                "Os Vingadores se reúnem para desfazer as ações de Thanos e restaurar o universo.",
                "https://via.placeholder.com/300x450/000000/FFFFFF?text=Vingadores+Ultimato",
                2019,
                "Anthony e Joe Russo",
                "Ação"
            );
            movieRepository.save(movie11);

            Movie movie12 = new Movie(
                "O Silêncio dos Inocentes",
                "Uma jovem agente do FBI busca a ajuda de um psicopata para capturar outro serial killer.",
                "https://via.placeholder.com/300x450/000000/FFFFFF?text=O+Silêncio+dos+Inocentes",
                1991,
                "Jonathan Demme",
                "Suspense"
            );
            movieRepository.save(movie12);

            Movie movie13 = new Movie(
                "Fight Club",
                "Um homem insatisfeito com sua vida conhece um vendedor de sabão e juntos criam um clube de luta clandestino.",
                "https://via.placeholder.com/300x450/000000/FFFFFF?text=Fight+Club",
                1999,
                "David Fincher",
                "Drama"
            );
            movieRepository.save(movie13);

            Movie movie14 = new Movie(
                "O Resgate do Soldado Ryan",
                "Um grupo de soldados é enviado atrás das linhas inimigas para resgatar um soldado cujos irmãos morreram na guerra.",
                "https://via.placeholder.com/300x450/000000/FFFFFF?text=O+Resgate+do+Soldado+Ryan",
                1998,
                "Steven Spielberg",
                "Guerra"
            );
            movieRepository.save(movie14);

            Movie movie15 = new Movie(
                "O Exterminador do Futuro 2",
                "Um cyborg é enviado do futuro para proteger um jovem que será crucial para a sobrevivência da humanidade.",
                "https://via.placeholder.com/300x450/000000/FFFFFF?text=O+Exterminador+do+Futuro+2",
                1991,
                "James Cameron",
                "Ação"
            );
            movieRepository.save(movie15);

            Movie movie16 = new Movie(
                "O Labirinto do Fauno",
                "Uma menina de 10 anos se refugia em um mundo de fantasia para escapar da crueldade da Guerra Civil Espanhola.",
                "https://via.placeholder.com/300x450/000000/FFFFFF?text=O+Labirinto+do+Fauno",
                2006,
                "Guillermo del Toro",
                "Fantasia"
            );
            movieRepository.save(movie16);

            Movie movie17 = new Movie(
                "Mad Max: Estrada da Fúria",
                "Em um mundo pós-apocalíptico, um homem busca vingança contra aqueles que roubaram sua família.",
                "https://via.placeholder.com/300x450/000000/FFFFFF?text=Mad+Max+Estrada+da+Fúria",
                2015,
                "George Miller",
                "Ação"
            );
            movieRepository.save(movie17);

            Movie movie18 = new Movie(
                "Parasita",
                "Uma família pobre se infiltra na casa de uma família rica, mas os planos não saem como esperado.",
                "https://via.placeholder.com/300x450/000000/FFFFFF?text=Parasita",
                2019,
                "Bong Joon-ho",
                "Suspense"
            );
            movieRepository.save(movie18);

            Movie movie19 = new Movie(
                "Joker",
                "Um comediante falido se transforma em um criminoso psicopata na cidade de Gotham.",
                "https://via.placeholder.com/300x450/000000/FFFFFF?text=Joker",
                2019,
                "Todd Phillips",
                "Drama"
            );
            movieRepository.save(movie19);

            Movie movie20 = new Movie(
                "Duna",
                "Um jovem nobre é enviado para um planeta deserto onde uma substância valiosa é extraída.",
                "https://via.placeholder.com/300x450/000000/FFFFFF?text=Duna",
                2021,
                "Denis Villeneuve",
                "Ficção Científica"
            );
            movieRepository.save(movie20);

            Movie movie21 = new Movie(
                "Top Gun: Maverick",
                "Pete 'Maverick' Mitchell retorna para treinar uma nova geração de pilotos para uma missão perigosa.",
                "https://via.placeholder.com/300x450/000000/FFFFFF?text=Top+Gun+Maverick",
                2022,
                "Joseph Kosinski",
                "Ação"
            );
            movieRepository.save(movie21);

            Movie movie22 = new Movie(
                "Everything Everywhere All at Once",
                "Uma mulher chinesa-americana deve salvar o multiverso enquanto lida com problemas familiares.",
                "https://via.placeholder.com/300x450/000000/FFFFFF?text=Everything+Everywhere",
                2022,
                "Daniel Kwan e Daniel Scheinert",
                "Ficção Científica"
            );
            movieRepository.save(movie22);

            Movie movie23 = new Movie(
                "Oppenheimer",
                "A história de J. Robert Oppenheimer e seu papel no desenvolvimento da bomba atômica.",
                "https://via.placeholder.com/300x450/000000/FFFFFF?text=Oppenheimer",
                2023,
                "Christopher Nolan",
                "Drama"
            );
            movieRepository.save(movie23);
        }
    }
} 