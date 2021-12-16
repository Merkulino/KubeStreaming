package com.example.kubestreaming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.kubestreaming.adapter.RecycleViewAdapter;
import com.example.kubestreaming.adapter.RecyclerItemClickListener;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private CarouselView carouselView;

    private ArrayList<Movie> mainMovies = new ArrayList<>();
    private ArrayList<Movie> featuredMovies = new ArrayList<>();
    private ArrayList<Movie> noirMovies = new ArrayList<>();
    private ArrayList<Movie> blackMovies = new ArrayList<>();
    private ArrayList<Movie> westernMovies = new ArrayList<>();
    private ArrayList<Movie> lastDecadeMovies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Movies List
        initRecycleView();
        createMovieObjects();

        //Carousel images and listener
        carouselView = findViewById(R.id.carouselViewID);
        carouselView.setPageCount(mainMovies.size());
        carouselView.setImageListener( ImageListener );

        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                movieDescriptionActivity(mainMovies.get(position));
            }
        });
    }

    //Set Carousel imgListner
    ImageListener ImageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {

            Movie movie = mainMovies.get(position);
            imageView.setImageResource(movie.getImg());

        }
    };

    //RecycleView Adapter Config
    private void initRecycleView(){

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recicleViewID);
        recyclerView.setLayoutManager(layoutManager);
        RecycleViewAdapter adapter = new RecycleViewAdapter(this, featuredMovies);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                recyclerView,
                new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                Movie movie = featuredMovies.get(position);
                movieDescriptionActivity(movie);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));


        //recycle2

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView1 = findViewById(R.id.recicleViewID1);
        recyclerView1.setLayoutManager(layoutManager1);
        RecycleViewAdapter adapter2 = new RecycleViewAdapter(this, noirMovies);
        recyclerView1.setAdapter(adapter2);

        recyclerView1.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                recyclerView1,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                        Movie movie = noirMovies.get(position);
                        movieDescriptionActivity(movie);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }
        ));


        //recycle3

        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView2 = findViewById(R.id.recicleViewID2);
        recyclerView2.setLayoutManager(layoutManager2);
        RecycleViewAdapter adapter3 = new RecycleViewAdapter(this, blackMovies);
        recyclerView2.setAdapter(adapter3);

        recyclerView2.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                recyclerView2,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                        Movie movie = blackMovies.get(position);
                        movieDescriptionActivity(movie);

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }
        ));


        //recycle4

        LinearLayoutManager layoutManager3 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView3 = findViewById(R.id.recicleViewID3);
        recyclerView3.setLayoutManager(layoutManager3);
        RecycleViewAdapter adapter4 = new RecycleViewAdapter(this, westernMovies);
        recyclerView3.setAdapter(adapter4);

        recyclerView3.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                recyclerView3,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                        Movie movie = westernMovies.get(position);
                        movieDescriptionActivity(movie);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }
        ));


        //recycle5

        LinearLayoutManager layoutManager4 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView4 = findViewById(R.id.recicleViewID4);
        recyclerView4.setLayoutManager(layoutManager4);
        RecycleViewAdapter adapter5 = new RecycleViewAdapter(this, lastDecadeMovies);
        recyclerView4.setAdapter(adapter5);

        recyclerView4.addOnItemTouchListener(new RecyclerItemClickListener(
                getApplicationContext(),
                recyclerView4,
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                        Movie movie = lastDecadeMovies.get(position);
                        movieDescriptionActivity(movie);
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }
        ));

    }

    //Movies Database
    private void createMovieObjects(){

        //Main Movies
        Movie movie1 = new Movie("Blade Runner",1,1982,117,R.drawable.bladerunner_poster,
                "No século 21, uma corporação desenvolve clones humanos para serem usados como escravos em colônias fora da Terra, identificados como replicantes. Em 2019, um ex-policial é acionado para caçar um grupo fugitivo vivendo disfarçado em Los Angeles.");

        Movie movie2 = new Movie("Die Hard",2,1988,131,R.drawable.diehard_poster,
                "NYPD cop John McClane’s plan to reconcile with his estranged wife is thrown for a serious loop when, minutes after he arrives at her office, the entire building is overtaken by a group of terrorists. With little help from the LAPD, wisecracking McClane sets out to single-handedly rescue the hostages and bring the bad guys down.");

        Movie movie3 = new Movie("The Treasure of the Sierra Madre",3,1948,126,R.drawable.sieramadre_poster,
                "O Dr. Drew Pinsky fala sobre os vícios silenciosos que acometem mães e donas de casa, que hoje atingem números alarmantes. Casos de dependência de remédios controlados são comuns, mas vícios mais insidiosos, como o da compra, passam despercebidos.");

        Movie movie4 = new Movie("Mad Max: Fury Road",4,2015,120,R.drawable.furyroad_poster,
                "Num mundo apocalíptico, uma mulher se rebela contra um tirano ao procurar uma nova casa para um grupo de mulheres prisioneiras com a ajuda dum homem chamado Max.");

        Movie movie5 = new Movie("Joker",5,2019,122,R.drawable.jokerposter,
                "Isolado, intimidado e desconsiderado pela sociedade, o fracassado comediante Arthur Fleck inicia seu caminho como uma mente criminosa após assassinar três homens em pleno metrô. Sua ação inicia um movimento popular contra a elite de Gotham City, da qual Thomas Wayne é seu maior representante.");

        mainMovies.add(movie1);
        mainMovies.add(movie2);
        mainMovies.add(movie3);
        mainMovies.add(movie4);
        mainMovies.add(movie5);


        //Featured Movies

        Movie movie6 = new Movie("The Power of The Dog",6,2021,126,R.drawable.powerofthedog_poster, R.drawable.thepowerofdog_iconposter ,
                "Charismatic rancher Phil Burbank inspires fear and awe in those around him. When his brother brings home a new wife and her son, Phil torments them until he finds himself exposed to the possibility of love.");

        Movie movie7 = new Movie("Dune",7,2021,155,R.drawable.dune_poster, R.drawable.dune_iconposter,
                "Feature adaptation of Frank Herbert's science fiction novel about the son of a noble family entrusted with the protection of the most valuable asset and most vital element in the galaxy.");

        Movie movie8 = new Movie("The Last Duel",8,2021 ,152,R.drawable.lastduel_poster, R.drawable.lastduel_iconposter,
                "King Charles VI declares that Knight Jean de Carrouges settle his dispute with his squire by challenging him to a duel.");

        Movie movie9 = new Movie("House of Gucci",9,2021,158,R.drawable.gucci_poster, R.drawable.gucci_iconoposter,
                "When Patrizia Reggiani, an outsider from humble beginnings, marries into the Gucci family, her unbridled ambition begins to unravel their legacy and triggers a reckless spiral of betrayal, decadence, revenge, and ultimately...murder.");

        Movie movie10 = new Movie("Last Night in Soho",10,2021,117,R.drawable.soho_poster, R.drawable.soho_iconposter,
                "An aspiring fashion designer is mysteriously able to enter the 1960s where she encounters a dazzling wannabe singer. But the glamour is not all it appears to be and the dreams of the past start to crack and splinter into something darker.");


        featuredMovies.add(movie6);
        featuredMovies.add(movie7);
        featuredMovies.add(movie8);
        featuredMovies.add(movie9);
        featuredMovies.add(movie10);


        //Film Noir

        Movie movie11 = new Movie("Sunset Boulevard",11,1950,110,R.drawable.sunset_poster, R.drawable.sunsetboule_iconposter,
                "A screenwriter develops a dangerous relationship with a faded film star determined to make a triumphant return.");

        Movie movie12 = new Movie("The Third Man",12,1949,104,R.drawable.thirdman_poster, R.drawable.thethirdman_iconposter,
                "Pulp novelist Holly Martins travels to shadowy, postwar Vienna, only to find himself investigating the mysterious death of an old friend, Harry Lime.");

        Movie movie13 = new Movie("Gilda",13,1946,110,R.drawable.gilda_poster, R.drawable.gilda_iconposter,
                "A small-time gambler hired to work in a Buenos Aires casino discovers his employer's new wife is his former lover.");

        Movie movie14 = new Movie("Rebecca",14,1940,130,R.drawable.rebecca_poster, R.drawable.rebecca_iconposter,
                "A self-conscious woman juggles adjusting to her new role as an aristocrat's wife and avoiding being intimidated by his first wife's spectral presence.");

        Movie movie15 = new Movie("The Maltese Falcon",15,1941,100,R.drawable.maltese_poster, R.drawable.maltese_iconposter,
                "San Francisco private detective Sam Spade takes on a case that involves him with three eccentric criminals, a gorgeous liar, and their quest for a priceless statuette, with the stakes rising after his partner is murdered." );


        noirMovies.add(movie11);
        noirMovies.add(movie12);
        noirMovies.add(movie13);
        noirMovies.add(movie14);
        noirMovies.add(movie15);


        //Black Movies

        Movie movie16 = new Movie("Shaft",16,1971,100,R.drawable.shaft_poster, R.drawable.shaft_iconposter,
                "Ao ser contratado por um chefão da máfia do Harlem para localizar sua filha adolescente sequestrada, o detetive negro John Shaft acaba se metendo no meio de uma guerra entre gangues de traficantes rivais.");

        Movie movie17 = new Movie("Blacula",17,1972,93,R.drawable.blacula_poster, R.drawable.blacula_iconposter,
                "Drácula transforma o príncipe africano Manuwalde em um vampiro e o aprisiona em um caixão. Quando Blacula acorda séculos depois, ele parte em uma busca sangrenta pela reencarnação do seu grande amor.");

        Movie movie18 = new Movie("Coffy",18,1973,90,R.drawable.coffy_poster, R.drawable.coffy_iconposter,
                "Uma sexy enfermeira negra faz justiça vigilante contra traficantes de drogas do centro da cidade depois que sua irmã se torna a última vítima deles.");

        Movie movie19 = new Movie("Uptown Saturday Night",19,1974,104,R.drawable.uptown_poster, R.drawable.uptown_iconposter,
                "At Madame Zenobia's illegal nightclub, when Steve Jackson and Wardell Franklin get robbed of their wallets containing a winning lottery ticket, they set out to recover it.");

        Movie movie20 = new Movie("Foxy Brown",20,1982,93,R.drawable.foxybrown_poster, R.drawable.foxybrown_iconposter,
                "Uma voluptuosa vigilante negra aceita um trabalho como prostituta de luxo para se vingar dos mafiosos que assassinaram seu namorado.");


        blackMovies.add(movie16);
        blackMovies.add(movie17);
        blackMovies.add(movie18);
        blackMovies.add(movie19);
        blackMovies.add(movie20);

        //Western Movies

        Movie movie21 = new Movie("The Good The Bad And The Ugly",21,1966,161,R.drawable.goodbadugly_poster, R.drawable.thegoodbadugly_iconposter,
                "A bounty hunting scam joins two men in an uneasy alliance against a third in a race to find a fortune in gold buried in a remote cemetery.");

        Movie movie22 = new Movie("Once Upon a Time in West",22,1968,165,R.drawable.uponatimeinwest_poster, R.drawable.onceuponatime_iconposter,
                "A mysterious stranger with a harmonica joins forces with a notorious desperado to protect a beautiful widow from a ruthless assassin working for the railroad.");

        Movie movie23 = new Movie("Django",23,2012,165,R.drawable.django_poster, R.drawable.django_iconposter,
                "With the help of a German bounty-hunter, a freed slave sets out to rescue his wife from a brutal plantation-owner in Mississippi.");

        Movie movie24 = new Movie("Red River",24,1948,133,R.drawable.redriver_poster, R.drawable.redriver_iconposter,
                "Dunson leads a cattle drive, the culmination of over 14 years of work, to its destination in Missouri. But his tyrannical behavior along the way causes a mutiny, led by his adopted son.");

        Movie movie25 = new Movie("Stagecoach",25,1939,96,R.drawable.stagecoach_poster, R.drawable.stagecoach_iconposter,
                "A group of people traveling on a stagecoach find their journey complicated by the threat of Geronimo and learn something about each other in the process.");

        westernMovies.add(movie21);
        westernMovies.add(movie22);
        westernMovies.add(movie23);
        westernMovies.add(movie24);
        westernMovies.add(movie25);

        //2010s Movies

        Movie movie26 = new Movie("Avengers: Endgame",26,2019,181,R.drawable.endgame_poster, R.drawable.endgame_iconposter,
                "After the devastating events of Vingadores: Guerra Infinita (2018), the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos' actions and restore balance to the universe.");

        Movie movie27 = new Movie("Parasite",27,2019,132,R.drawable.parasite_poster, R.drawable.parasite_iconposter,
                "Greed and class discrimination threaten the newly formed symbiotic relationship between the wealthy Park family and the destitute Kim clan.");

        Movie movie28 = new Movie("Whiplash",28,2014,106,R.drawable.whiplash_poster, R.drawable.whiplash_iconposter,
                "A promising young drummer enrolls at a cut-throat music conservatory where his dreams of greatness are mentored by an instructor who will stop at nothing to realize a student's potential.");

        Movie movie29 = new Movie("1917",29,2019,119,R.drawable.war1917_poster, R.drawable.war1917_icon,
                "April 6th, 1917. As a regiment assembles to wage war deep in enemy territory, two soldiers are assigned to race against time and deliver a message that will stop 1,600 men from walking straight into a deadly trap." );

        Movie movie30 = new Movie("BlacKkKlansman",30,2018,128,R.drawable.blackkk_poster, R.drawable.blackkk_iconposeter,
                "Um policial afro americano de Colorado, consegue infiltrar-se com sucesso na filial local da Ku Klux Klan com a ajuda de um judeu que eventualmente se torna seu líder. Baseado em eventos reais.");


        lastDecadeMovies.add(movie26);
        lastDecadeMovies.add(movie27);
        lastDecadeMovies.add(movie28);
        lastDecadeMovies.add(movie29);
        lastDecadeMovies.add(movie30);

    }

    //Link to Movie Activity
    private void movieDescriptionActivity(Movie objeto){

        Intent intent = new Intent(MainActivity.this, MovieDescription.class);
        intent.putExtra("object", objeto);
        startActivity(intent);
        onStop();

    }

}