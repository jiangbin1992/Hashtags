package com.tito.megahashtagsinsta;

import static com.best.now.myad.utils.Constant.URL_PRIVACY_POLICY;
import static com.best.now.myad.utils.PublicHelperKt.loadAd;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.best.now.myad.WebActivity;

import java.util.ArrayList;
import java.util.List;

public class FragmentAllHashtags extends Fragment {
    FragmentActivity activity;
    Context mContext;
    List<Hashtags> hashtagsList;
    RecyclerView mRecyclerView;
    RecyclerViewAdapter mRecyclerViewAdapter;
    FragmentManager fragmentManager;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mContext = getActivity().getApplicationContext();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_all_hashtags, container, false);
        LinearLayout advBanner = myView.findViewById(R.id.advBanner);
        loadAd(advBanner);
        TextView PrivacyPolicy = myView.findViewById(R.id.PrivacyPolicy);
        PrivacyPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebActivity.Companion.startActivity(getActivity(), "Privacy Policy", URL_PRIVACY_POLICY);
            }
        });
        mRecyclerView = myView.findViewById(R.id.recyclerViewAllAppsAndGames);
        hashtagsList = new ArrayList<>();
        fragmentManager = getActivity().getSupportFragmentManager();
        //Adding A New Collections Here
        hashtagsList.add(new Hashtags("Sport", "Football", "#Foot #Soccer#Skiller #433 #Fcb #Ucl #Ronaldo #Cristiano #Football #Soccer #Footy #Barcelonafc #Teamfkskills #Soccergirl #Bornmercurial #Fifa19 #Futbol #Zlatan #Skill #Nike #Fifa#adidasfootball #heretocreate #football #soccer #futebol #futbol #voetbal#barcelona #barca #calcio #zlatan #halamadrid #pogba #manchesterunited #futebol #footballseason #cristiano #footballgame #fcbarcelona #arsenal #footballplayer", R.drawable.football));
        hashtagsList.add(new Hashtags("Emotional", "Love", "#love#like#friends#amazing#funny#lovestories#iloveyou#inlove#lovetheworld#bf#gf#girl#couple#babylove#lovequotes#loveher", R.drawable.love));
        hashtagsList.add(new Hashtags("Life", "Babies", "#baby #photooftheday #newbornphotography #babybump #kids #babies #mama #newborn #photography #mommy #cute #love #photographer #maternity #babygirl #mom #pregnant #pregnancy #momtobe #motherhood #photoshoot #family #happy #babyboy #parenting #mother #maternityphotography #momlife #babyshower #babylove", R.drawable.baby));
        hashtagsList.add(new Hashtags("Sport", "Basketball", "#derrickjonesjr #miamiheat #nbahighlights #nba #nbaart #dunkin #slamdunk #procreate #nbaart #ball #basketball#basketballneverstops #nbabasketball #basketballvideos #basketballvines #ball #nbadraft #mixtape #sports #dunk #basketballgame #ballislife #wesbrook #lebronjames #kobebryant #kobe", R.drawable.basketball));
        hashtagsList.add(new Hashtags("Art", "Dancers", "#music #dance #dancer #dancers #money #hiphopdance #hiphop #jazz #dancersofinstagram #kiddancer #instadance #instagood #talentworlds #instagram #viral #viralvideo #viraldance #dancecompetition #dancecompany #dancelife #hiphopmusic #hiphopculture #dancing #hiphoplife #hiphopdancer #dancelove#indiandance#dance#dancer#dancers#dancing#danceislife#dancelife#ballet#ballerina#balletdance#flexible#flexibility", R.drawable.dancers));
        hashtagsList.add(new Hashtags("Life", "Food", "#mealprep #chicken #food #foodie #delicious #potatoes #foodprep#foodporn#yum#hungry#sweet #yummy #tasty #banana#healthyfoodporn#healthylunch#eggs#potato", R.drawable.food));
        hashtagsList.add(new Hashtags("Holidays", "Halloween", " #halloween#donteatthegum #whatsinthebox #horror #childsplay #fangoria #halloween #scary #monsters #talesfromthecrypt #shockstudios #aliens#halloweenmakeup #halloweenmakeupideas #redlips", R.drawable.hallowen));
        hashtagsList.add(new Hashtags("Animals", "Tigers", "#bigcats #Tiger #tigereye#lovetiger #seewildlife #destination_wild #wildlife_photography #natgeowild #natgeoyourshot #tiger #tigers #wildlifelovers #animalelite  #animal #animals #exclusive_wildlife#blackandwhitecat#pets_perfection #wildlife #wildlife_vision #africa", R.drawable.animals));
        hashtagsList.add(new Hashtags("Plants", "Flowers", "#spring #flowers#thebeauty#countryside #walk #walking #landscapephotography #nature#floweroftheday #amazing #plants #prilaga #flowersofinstagram #nature #spring #flowerstyles_gf #flowermagic #instablooms #bloom #flowers #blossom #petals #botanical #insta_pick_blossom #photooftheday #floral #florals#flowerslovers", R.drawable.fllowers));
        hashtagsList.add(new Hashtags("lifestyle", "Travel", "#travel #travelphotography #instatravel #travelling #travelblogger #traveling #traveler #traveller #photography #wanderlust #travels #photooftheday #travelblog #nature #instagood #trip #travelholic #travelphoto #travelers #beautifuldestinations #vacation #traveladdict #travellers #travelguide #travelpic #travelpics #traveltheworld", R.drawable.travelers));
        hashtagsList.add(new Hashtags("Holidays", "Christmas", "#celebrate #celebrations #pink #flower #christmas#family #christmas #festivities#Christmas #time#deer #crafts #iloveart #christmas #bottlebrushtrees #vintagedeer #classicchristmas #artandcrafts #handmade #glitter #christmascards #2019 #ilovecrafts", R.drawable.chrismas));
        hashtagsList.add(new Hashtags("Animals", "Cats", "#cat #cats #kitty #catsofinstagram #catsoftheday #instacat #petstagram #bestmeow #caturday #petsofinstagram #meowbox #catoftheday #catofig #kitten #kitties #petsofig #kittens #meow #instapet #catlover #catsagram #catlove #catsofworld #catlovers #lovecats #animals #animal #pet#blackcatsofinstagram #blackcat #blackcatclub #rescuecat #adoptdontshop #pawty #catdaddy #cutecats #catlife #blackcatcrew #petphotography #cuteanimals #cats #minipanther #catsofinstagram #catdad #fluffycat #blackcatsrock #blackcatsmatter", R.drawable.cats));
        hashtagsList.add(new Hashtags("Lifestyle", "Yoga", "#selflove #aloyoga #bodypositivity #yogapants #loveyourself #love #yogadaily #yogafam #yogacommunity #bendy #yogafit #namaste #yogaeveryday #yogaeverydamnday #om #yogalove #fitgirlsguide #happy #backbend #yogastrong #instagood #photooftheday #yogamagic #strongwomen #beyourself #practiceandalliscoming #perfectlyimperfect #flexability #safetyfirst #camelpose", R.drawable.yoga));
        hashtagsList.add(new Hashtags("Mecanic", "Cars", "#ferrariportofino #ferrari #portofino #ferraripolska#amazingcars247 #photooftheday #royalcarsmg#instacar#carporn#carlifestyle #sportscar #carstagram #ItsWhiteNoise #supercarsoftr#carlovers#car#carlife#audi#ferrari#lamborghini#classiccarsculture #Classic #classics #Classiccar #classiccars #car #amazingcars247 #autotrend  ", R.drawable.car));
        hashtagsList.add(new Hashtags("Mecanic", "Bike", "#motorbike #motorcycle #bike #ducati #bmw #yamaha #kawasaki #love #couplegoals #bikelife #motorrad  #bikergirls #superbikesgram #sportbikeaddicts #мотоцикл #sportbikelife #moto #supermoto #braap #motor #supersport#motorcycles #motorcycle #sportbike #sportbikelife #bikelife #motogp #superbikes #rateit #badass #ktm #yamaha #bike #biker #motorbike #moto  #superbike #enduro #bikes #sbk #cyclelaw #bikekings #bikeporn #gopro #BWL #Ducati #motorcyclemadness #RevMafia #motorcyclenuts", R.drawable.bike));
        hashtagsList.add(new Hashtags("Sport", "Gym", "#health #fitness #fit #gym #motivation #workout #bodybuilding #healthy #lifestyle #fitspo#training #instagood #fitnessmodel #fitnessmotivation #diet #strong #muscle#fitnessaddict#eatclean #exercise #gymlife #bodybuilding #bodybuilder#gym #teamvitalflora #fitness#stronger #paradise #fitfam #fitness #gym #gymlife #lifestyle #happylife", R.drawable.gym));
        hashtagsList.add(new Hashtags("Lifestyle", "Photographer", "#photooftheday #photo #photographer #naturephotography #photo #photography #photographer#photography #slr #slrcamera #photographyeveryday #ig_shutterbugs #photographer #canon #slrcanon #ilovephotography #dslr_photography #dslr #slr_photography #keepfilmalive #photos #photographylovers #beautiful", R.drawable.photographer));
        hashtagsList.add(new Hashtags("Lifestyle", "Adventure", "#adventure#TheGreatOutdoors #DailyAdventures#Adrenalin  #wow #impressive#travel #trip #wanderlust  #survive #nature #mountain #survival#aventura #explore #explorers#roadtrip  #bikerlife #photooftheday #trip #instaphoto #royalenfieldreposts#instaphotographer #model #landscape #enfieldwanderer", R.drawable.adventure));
        hashtagsList.add(new Hashtags("Seasons", "Summer", "#blue #summer#tanned #simbora #sol #sunset sea#meer#thailand #phiphiisland #paradise #goprohero7black #summer #happy #love #beach #phiphi #vacay#vacations #modeon", R.drawable.summer));
        hashtagsList.add(new Hashtags("Lifestyle", "Shopping", "#shopping #shop #shoppings #shoppingbags #toptags #shoppingtime #shoppingmall #shoppingaddict #shoppingcenter #shoppingtherapy #instashopping #happy #tweegram #instagood #hapyshopping #igshopping #goodliving #goodvibes #shoppingspree #igers #mall #dresstoimpress #instadaily #besttime #instamood #weloveshopping #store#shop #shopping #cute #PR #sscollectivejp #sslooksjp #shopstylejp#clothing #fashion #style #streetwear#art #apparel #clothingbrand #model #streetstyle #brand#clothingline #fashionista  #menswear", R.drawable.shopping));
        hashtagsList.add(new Hashtags("Business", "Work", "#work #workworkwork #tallbuildings #goals #dreams #building #buildings #architecture #brisbane #brisbanecity #highrise#security #bouncer #milanfashionweek #fashionevent #moda #milano #work #backhome #alone #settimanadellamoda #fashionparty #fashion #model #models#Goals #work #trabajo#NewYork #USA #Oportunidad #Opportunity", R.drawable.work));
        hashtagsList.add(new Hashtags("Technology", "Coding", "#programmer #programming #coding#developer #coder #html #css #security#javascript #python #php #webdeveloper#monday #software #google#softwaredeveloper #gotocode #technology#computer #tech #webdesign #linux #apple#windows #codinglife #motivation#webdevelopment #computerscience#softwareengineering#programmer #programming #coding #coderlife #code #coder #developer #development #webdeveloper #programminghumour #programmingmemes #softwaredeveloper #softwareengineer #software #programing #computer #technology #hacking #code #python #javascript #java #webdeveloper #webdesign #funny #datascience #algorithm", R.drawable.coding));
        hashtagsList.add(new Hashtags("Seasons", "Autumn", "#autumn #fall#treehugger #treeshunter #treetops #treestagram #treelover #treelove #treesofinstagram #treetrunks #nature #naturelovers #tree #trees #scape_captures#wood #woods #leaves #autumn#maple #trees #treephotography #leaves #autumn #seasons #colourful #bright #morningsun #nature #naturelovers", R.drawable.automne));
        hashtagsList.add(new Hashtags("Party", "Bithday", "#celebration #birthday #birthdaygirl #birthdaycake#birthday #party #18th#birthdaycookies#aniversario #19 #daughter #birthdaygirl #bday #party #photography #instapic #instabday #bestoftheday #birthdaycake #cake #friends #celebrate#candle #candles #happy #young #old #years #instacake #happybirthday #instabirthday #born #family", R.drawable.bithday));
        hashtagsList.add(new Hashtags("Building", "Architecture", "#architecture #building #design #designer #arquitectura #arquitetura #archilovers #architecturelovers #architectural#inspiringarchitect #arch_more #architecture #architect #architizer #design #archilovers#iarchitectures #next_top_architects  #nextarch #archdaily#architecturelovers #instadesign #instaarchitecture #archidesign #architecturedesign #homedesign #contemporary #architecten#archimodel #akitekucha #archiwizard #architecture_hunter #artsytecture", R.drawable.archi));
        hashtagsList.add(new Hashtags("Life", "Familly", "#amor #familly #family #familia#behappy#familygoals #famillytime#familles#momandkids#familylife #familymoment #familypark #familyfun #familygoals #familygoals #familytime #familyisforever #family #fungoals #funfamily #children #childcare #parenthood_moments #parentaladvisory #parenthood #parentingtips #parenting #parent #funny #familly #parentinglife #parentinggoals#parents", R.drawable.familly));
        hashtagsList.add(new Hashtags("Hobby", "Reading", "#books #bookstagram #instabooks #instareads #shelfie #reader #reading #ya #yabooks #author #bookish #booknook #bookshelves #rainbowshelf #bookspines #booklove#bookstagramer #bookquote #bookdragon", R.drawable.books));


        mRecyclerViewAdapter = new RecyclerViewAdapter(getContext(), hashtagsList);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        mRecyclerView.setAdapter(mRecyclerViewAdapter);

        // Toast.makeText(getActivity().getApplicationContext(),"Test",Toast.LENGTH_LONG).show();

        return myView;


    }


}
