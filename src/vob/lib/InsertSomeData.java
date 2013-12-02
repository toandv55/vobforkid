package vob.lib;

import java.util.ArrayList;
import java.util.List;

import vob.model.Topic;
import vob.model.Word;
import vob.orm.TopicMapper;
import android.content.Context;
import android.util.Log;

public class InsertSomeData {
	Context context;
	
	
	public Context getContext() {
		return context;
	}
	public void setContext(Context context) {
		this.context = context;
	}
	public InsertSomeData(Context mycontext) {
		context= mycontext;
		
	
		
		
	}
	public void insertTopic(){
		TopicMapper topicMaper = new TopicMapper(context);
				
		Topic animal = new Topic(1, "animal", "animal", null );
		Topic clothes = new Topic(2, "clothes", "clothes", null );
		Topic food = new Topic(3, "food", "food", null );
		Topic fairytail = new Topic(4,"fairy tail", "fairy tail", null);
		Topic emotion = new Topic(5,"emotion", "emotion", null);
		Topic family = new Topic(6,"family", "family", null);
		Topic holiday = new Topic(7,"holiday", "holiday", null);
		Topic body = new Topic(8,"body", "body", null);
		Topic job = new Topic(9,"job", "job", null);
		Topic sport = new Topic(10,"sport", "sport", null);
		Topic transportaion = new Topic(11,"transportaion", "transportaion", null);
		Topic wheather = new Topic(12,"wheather", "wheather", null);
		
		Log.d ("Insert ","Initiate inserting new topics  ");
		topicMaper.add(animal);
		topicMaper.add(clothes);
		topicMaper.add(food);
		topicMaper.add(fairytail);
		topicMaper.add(emotion);
		topicMaper.add(family);
		topicMaper.add(holiday);
		topicMaper.add(body);
		topicMaper.add(job);
		topicMaper.add(sport);
		topicMaper.add(transportaion);
		topicMaper.add(wheather);
		
		
		Log.d ("Insert ","Inserting topic success");
	}
	
	public void insertWord(){
//		Create topic List
		Topic animal = new Topic(1, "animal", "animal", null );
		Topic clothes = new Topic(2, "clothes", "clothes", null );
		/*
		Create WordList to be insert
		1st List Animal*/
		
		Word bird = new Word (	"bird","bɜd",	"con chim", "bird",	"bird",	animal);
		Word chicken = new Word (	"chicken",	"tʃɪk.ɪn",	"con gà", "chicken",	"chicken",	animal);
		Word cow = new Word (	"cow",	"kaʊ",	"con bò", "cow",	"cow",	animal);
		Word crocodile = new Word (	"crocodile",	"krɒk.ə.daɪl",	"cá sấu",	 "crocodile",	"crocodile",	animal);
		Word dog = new Word ("dog","dɒg","con chó", "dog","dog",animal);
		Word duck = new Word ("duck","dʌk","con vịt", "duck","duck",animal);
		Word elephant = new Word ("elephant","el.ɪ.fənt ","con voi", "elephant","elephant",animal);
		Word frog = new Word ("frog","frɒg","con ếch", "frog","frog",animal);
		Word goat = new Word ("goat","gəʊt","con dê", "goat","goat",animal);
		Word hippopotamus = new Word ("hippopotamus","hɪp.əpɒt.ə.məs ","hà mã", "hippo","hippo",animal);
		Word horse = new Word ("horse","hɔs","con ngựa", "horse","horse",animal);
		Word lizard = new Word ("lizard","lɪz.əd","con thằn lằn", "lizard","lizard",animal);
		Word monkey = new Word ("monkey","mʌŋ.ki","con khỉ", "monkey","monkey",animal);
		Word mouse = new Word ("mouse","maʊs","con chuột", "mouse","mouse",animal);
		Word sheep = new Word ("sheep","ʃip","con cừu", "sheep","sheep",animal);
		Word snake = new Word ("snake","sneɪk","con rắn", "snake","snake",animal);
		Word spider = new Word ("spider","spaɪ.dər","con nhện", "spider","spider",animal);
		Word tiger = new Word ("tiger","taɪ.gər","con hổ", "tiger","tiger",animal);
		
		List<Word> addList = new ArrayList<Word>();
		addList.add(bird);
		addList.add(chicken);
		addList.add(cow);
		addList.add(crocodile);
		addList.add(dog);
		addList.add(duck);
		addList.add(elephant);
		addList.add(frog);
		addList.add(goat);
		addList.add(hippopotamus);
		addList.add(horse);
		addList.add(lizard);
		addList.add(monkey);
		addList.add(mouse);
		addList.add(sheep);
		addList.add(snake);
		addList.add(spider);
		addList.add(tiger);
		
		Word bat = new Word("bat", "bæt ", "con dơi",animal);
		Word buffalo = new Word("buffalo", "bʌf.ə.ləʊ ", "con trâu",animal);
		Word bull = new Word("bull", "bʊl ", "bò tót",animal);
		Word butterfly = new Word("butterfly", "bʌt.ə.flaɪ ", "con bướm",animal);
		Word camel = new Word("camel", "kæm.əl", "lạc đà",animal);
		Word crab = new Word("crab", "/kræb/ ", "con cua",animal);
		Word deer = new Word("deer", "dɪər", "con dê",animal);
		Word dolphin = new Word("dolphin", "dɒl.fɪn ", "cá heo",animal);
		Word donkey = new Word("donkey", "dɒŋ.ki", "con lừa",animal);
		Word dragonfly = new Word("dragonfly", "dræg.ə n.flaɪ", "chuồn chuồn",animal);
		Word eagle = new Word("eagle", "i.gl", "đại bàng",animal);
		Word fawn = new Word("fawn", "fɔn ", "con dê con",animal);
		addList.add(bat);addList.add(deer);
		addList.add(buffalo);addList.add(dolphin);
		addList.add(bull);addList.add(donkey);
		addList.add(butterfly);addList.add(dragonfly);
		addList.add(camel);addList.add(eagle);
		addList.add(crab);addList.add(fawn);
		
		Word fish = new Word("fish", "fɪʃ ", "cá",animal);
		Word fox = new Word("fox", "fɒks ", "cáo",animal);
		Word giraffe = new Word("giraffe", "dʒɪrɑf ", "huơu cao cổ",animal);
		Word kitten = new Word("kitten", "kɪt.ən ", "mèo con",animal);
		Word lion = new Word("lion", "laɪ.ən ", "sư tử",animal);
		Word moose = new Word("moose", "mu:s ", "tuần lộc",animal);
		Word owl = new Word("owl", "aʊl ", "con cú",animal);
		Word panda = new Word("panda", "pæn.də ", "gấu trúc",animal);
		Word parrot = new Word("parrot", "pær.ət ", "con vẹt",animal);
		Word penguin = new Word("penguin", "peŋ.gwɪn ", "chim cánh cụt",animal);
		Word pig = new Word("pig", "pɪg ", "con lợn",animal);
		Word porcupine = new Word("porcupine", "pɔ.kjʊ.paɪn ", "con nhím",animal);
		
		addList.add(fish);addList.add(fox);
		addList.add(giraffe);addList.add(kitten);
		addList.add(lion);addList.add(moose);
		addList.add(owl);addList.add(panda);
		addList.add(parrot);addList.add(penguin);
		addList.add(pig);addList.add(porcupine);
		
		Word puppy = new Word("puppy", "pʌp.i ", "chó con",animal);
		Word rabbit = new Word("rabbit", "ræb.ɪt ", "con thỏ",animal);
		Word raccoon = new Word("raccoon", "rækun ", "gấu trúc Mỹ",animal);
		Word scorpion = new Word("scorpion", "skɔ.pi.ən ", "bọ cạp",animal);
		Word seal = new Word("seal", "sil ", "hải cẩu",animal);
		Word shark = new Word("shark", "ʃɑ:k ", "cá mập",animal);
		Word snail = new Word("snail", "sneɪl ", "ốc sên",animal);
		Word squirrel = new Word("squirrel", "skwɪr.əl", "sóc",animal);
		Word turkey = new Word("turkey", "tɜ.ki ", "gà tây",animal);
		Word turtle = new Word("turtle", "tɜ.tl ", "rùa",animal);
		Word whale = new Word("whale", "weɪl ", "cá voi",animal);
		Word wolf = new Word("wolf", "wʊlf ", "sói",animal);
		
		addList.add(puppy);addList.add(rabbit);
		addList.add(raccoon);addList.add(scorpion);
		addList.add(seal);addList.add(shark);
		addList.add(snail);addList.add(squirrel);
		addList.add(turkey);addList.add(turtle);
		addList.add(whale);addList.add(wolf);
		
		
		
		
		/*List Clothes*/ 
		Word bag = new Word("bag", "bæg", "túi xách", "bag", "bag", clothes);
        Word dress = new Word("dress", "dres", "váy", "dress", "dress", clothes);
        Word glasses = new Word("glasses", "glɑs", "con hổ", "glasses", "glasses", clothes);
        Word hat = new Word("hat", "hæt", "mũ", "hat", "hat", clothes);
        Word jacket = new Word("jacket", "dʒæk.ɪt", "áo khoác", "jacket", "jacket", clothes);
        Word jeans = new Word("jeans", "dʒinz", "quần jean", "jeans", "jeans", clothes);
        Word shoe = new Word("shoe", "taɪ.gər", "giày", "shoe", "shoe", clothes);
        Word sock = new Word("sock", "sɒk", "tất", "sock", "sock", clothes);
        Word trousers = new Word("trousers", "traʊ.zəz", "quần dài", "trousers", "trousers", clothes);
        Word watch = new Word("watch", "wɒtʃ", "đồng hồ", "watch", "watch", clothes);
        Word shirt = new Word("shirt", "ʃɜt", "áo sơ mi", "shirt", "shirt", clothes);

        addList.add(bag);
        addList.add(dress);
        addList.add(glasses);
        addList.add(hat);
        addList.add(jeans);
        addList.add(shoe);
        addList.add(sock);
        addList.add(trousers);
        addList.add(watch);
        addList.add(shirt);
        addList.add(jacket);
        
        Word belt = new Word("belt", "belt", "thắt lưng",clothes);
        Word boot = new Word("boot", "bu:t", "giày cao cổ",clothes);
        Word bowtie = new Word("bowtie", "baʊtaɪ ", "nơ",clothes);
        Word buckle = new Word("buckle", "bʌk.l", "thắt lưng",clothes);
        Word button = new Word("button", "bʌt.ən", "khuy áo",clothes);
        Word cap = new Word("cap", "kæp ", "mũ lưỡi trai",clothes);
        Word cardigan = new Word("cardigan", "kɑ.dɪ.gən", "áo len",clothes);
        Word coat = new Word("coat", "kəʊt ", "áo khoác",clothes);
        Word fur = new Word("fur", "fɜ:r", "áo lông",clothes);
        Word glove = new Word("glove", "glʌv ", "găng tay",clothes);
        Word handbag = new Word("handbag", "hænd.bæg", "túi xách",clothes);
        Word handkerchief = new Word("handkerchief", "hæŋ.kə.tʃif", "khăn tay",clothes);
        
        addList.add(belt);addList.add(boot);
        addList.add(bowtie);addList.add(buckle);
        addList.add(button);addList.add(cap);
        addList.add(coat);addList.add(fur);
        addList.add(glove);addList.add(handbag);
        addList.add(handkerchief);addList.add(cardigan);
        
        
        
        Word loafer = new Word("loafer", "ləʊ.fər", "giày lười",clothes);
        Word pants = new Word("pants", "pænts", "quần dài",clothes);
        Word pullover = new Word("pullover", "pʊləʊ.vər", "áo cổ chui",clothes);
        Word purse = new Word("purse", "pɜ:s", "ví nữ",clothes);
        Word pyjama = new Word("pyjama","pɪdʒɑ:mə", "đồ ngủ",clothes);
        Word raincoat = new Word("raincoat", "reɪŋ.kəʊt", "áo mưa",clothes);
        Word sandal = new Word("sandal", "sæn.dəl", "dep sandal",clothes);
        Word scarf = new Word("scarf", "skɑ:f", "khăn quàng",clothes);
        Word shoelace = new Word("shoelace", "ʃu.leɪs", "dây giày",clothes);
        Word skirt = new Word("skirt", "skɜ:t", "váy",clothes);
        Word slipper = new Word("slipper", "slɪp.ər", "dép đi trong nhà",clothes);
        addList.add(loafer);addList.add(pullover);
        addList.add(pants);addList.add(scarf);
        addList.add(purse);addList.add(shoelace);
        addList.add(pyjama);addList.add(skirt);
        addList.add(raincoat);addList.add(slipper);
        addList.add(sandal);
        
        Word sneaker = new Word("sneaker", "sni:kər", "giày",clothes);
        Word suit = new Word("suit", "sju:t", "bộ com lê",clothes);
        Word sweater = new Word("sweater", "swet.ər", "áo len dài tay",clothes);
        Word sweatshirt = new Word("sweatshirt", "swet.ʃɜt", "áo len",clothes);
        Word swimsuit = new Word("swimsuit", "swɪm.sjut", "đồ bơi",clothes);
        Word tanktop = new Word("tanktop", "tæŋktɒp ", "áo cổ rộng",clothes);
        Word tie = new Word("tie", "taɪ ", "ca vát",clothes);
        Word tight = new Word("tight", "taɪt", "quần bó",clothes);
        Word umbrella = new Word("umbrella", "ʌmbrel.ə", "ô",clothes);
        Word wallet = new Word("wallet", "wɒl.ɪt", "ví",clothes);
        Word zipper = new Word("zipper", "zɪp.ər", "khóa",clothes);
        addList.add(sneaker);addList.add(tight);
        addList.add(suit);addList.add(umbrella);
        addList.add(sweater);addList.add(wallet);
        addList.add(swimsuit);addList.add(zipper);
        addList.add(tanktop);addList.add(sweatshirt);
        addList.add(tie);
        
        
        
        /*3 List food*/
        Topic food = new Topic(3, "food", "food", null );
        
        Word bread = new Word("bread", "bred", "bánh mì", "bread", "bread", food);
        
        Word breakfast = new Word("breakfast", "bred", "bánh mì", "breakfast", "breakfast", food);
        Word cake = new Word("cake", "keɪk", "bánh ngọt", "cake", "cake", food);
        Word candy = new Word("candy", "kæn.di", "kẹo", "candy", "candy", food);
        Word carrot = new Word("carrot", "kær", "củ cà rốt", "carrot", "carrot", food);
        Word chocolate = new Word("chocolate", "tʃɒk.lət", "Chocolate", "chocolate", "chocolate", food);
        Word coconut = new Word("coconut", "kəʊ.kə.nʌt ", "quả dừa", "coconut", "coconut", food);
        Word dinner = new Word("dinner", "dɪn.ər", "bữa tối", "dinner", "dinner", food);
        
        Word fruit = new Word("fruit", "frut", "hoa quả", "fruit", "fruit", food);
        Word icecream = new Word("icecream", "aɪskrim", "kem", "icecream", "icecream", food);
        Word juice = new Word("juice", "dʒus", "nước hoa quả", "juice", "juice", food);
        Word lemonade = new Word("lemonade", "lem.əneɪd", "nước chanh", "lemonade", "lemonade", food);
        Word lunch = new Word("lunch", "lʌntʃ", "bữa trưa", "lunch", "lunch", food);
        Word milk = new Word("milk", "mɪlk ", "sữa", "milk", "milk", food);
        Word onion = new Word("onion", "ʌn.jən", "củ hành", "onion", "onion", food);
        Word pea = new Word("pea", "pi:", "đậu hà lan", "pea", "pea", food);
        Word rice = new Word("rice", "raɪs", "gạo", "rice", "rice", food);
        Word supper = new Word("supper", "sʌp.ər", "bữa tối", "supper", "supper", food);
        Word tomato = new Word("tomato", "təmɑ.təʊ", "cà chua", "tomato", "tomato", food);
        Word water = new Word("water", "wɔ.tər", "nước", "water", "water", food);
        Word watermelon = new Word("watermelon", "wɔ.təmel.ən", "dưa hấu", "watermelon", "watermelon", food);
       
        addList.add(bread);
        addList.add(breakfast);
        addList.add(cake);
        addList.add(candy);
        addList.add(chocolate);
        addList.add(coconut);
        addList.add(dinner);
  
        addList.add(fruit);
        addList.add(icecream);
        addList.add(lemonade);
        addList.add(lunch);
        addList.add(milk);
        addList.add(onion);
        addList.add(pea);
        addList.add(rice);
        addList.add(supper);
        addList.add(tomato);
        addList.add(water);
        addList.add(watermelon);
        addList.add(carrot);
        addList.add(juice);
        
        Word bacon = new Word("bacon", "beɪ.kən", "thịt lợn muối xông khói",food);
        Word bagel = new Word("bagel", "beɪ.gəl", "bánh mì hình nhẫn",food);
        Word cereal = new Word("cereal", "sɪə.ri.əl", "ngũ cốc",food);
        Word cheese = new Word("cheese", "tʃiz ", "bơ",food);
        Word coffee = new Word("coffee", "kɒf.i", "cà phê",food);
        Word cookie = new Word("cookie", "kʊk.i", "bánh quy",food);
        Word croissant = new Word("croissant", "kwæs.ɒ ", "bánh sừng bò",food);
        Word donut = new Word("donut", "dəʊ.nʌt ", "bánh rán",food);
        Word egg = new Word("egg", "eg", "trứng",food);
        Word hamburger = new Word("hamburger", "hæmbɜ.gər", "bánh humburger",food);
        addList.add(bacon);addList.add(bagel);
        addList.add(cereal);addList.add(cheese);
        addList.add(coffee);addList.add(cookie);
        addList.add(croissant);addList.add(donut);
        addList.add(egg);addList.add(hamburger);
        
        Word hotdog = new Word("hotdog", "hɒt.dɒg ", "bánh mì kẹp xúc xích",food);
        Word muffin = new Word("muffin", "mʌf.ɪn ", "bánh nướng xốp",food);
        Word nacho = new Word("nacho", "nætʃ.əʊ ", "khoai tây chiên thái mỏng",food);
        Word pizza = new Word("pizza", "pit.sə ", "bánh pizza",food);
        Word popcorn = new Word("popcorn", "pɒp.kɔn ", "bỏng ngô",food);
        Word salami = new Word("salami", "səlɑ.mi ", "xúc xính ý",food);
        Word sausage = new Word("sausage", "sɒs.ɪdʒ ", "lạp xưởng",food);
        Word soda = new Word("soda", "aa", "nước soda",food);
        Word sugar = new Word("sugar", "ʃʊg.ə r  ", "đường",food);
        Word sundae = new Word("sundae", "sʌn.deɪ", "mứt",food);
        Word syrup = new Word("syrup", "sɪr.əp", "xi rô",food);
        Word taco = new Word("taco", "tæk.əʊ", "bánh taco",food);
        Word toast = new Word("toast", "təʊst", "bánh mì nướng",food);
        Word waffle = new Word("waffle", "wɒf.l", "bánh quế",food);
        Word yogurt = new Word("yogurt", "joʊ.gɚt", "sữa chua",food);
        addList.add(hotdog);addList.add(muffin);
        addList.add(nacho);addList.add(pizza);
        addList.add(popcorn);addList.add(salami);
        addList.add(sausage);addList.add(sundae);
        addList.add(sugar);addList.add(syrup);
        addList.add(taco);addList.add(toast);
        addList.add(waffle);addList.add(yogurt);
        addList.add(soda);
     
      
        /*4. List fairy tail*/
        
        Topic fairytail = new Topic(4,"fairy tail", "fairy tail", null);
        Word castle = new Word("castle", 	"kɑ.sl", 	"lâu đài", 	"castle", 	"castle", 	fairytail);
        Word cinderella = new Word("cinderella", "sɪn.dərel.ə", "cô bé lọ lem", "cinderella", "cinderella", fairytail);
        Word crown = new Word("crown", "kraʊn", "vương miện", "crown", "crown", fairytail);
        Word dragon = new Word("dragon", "dræg.ən", "rồng", "dragon", "dragon", fairytail);
        Word dwarf = new Word("dwarf", "dwɔf", "chú lùn", "dwarf", "dwarf", fairytail);
        Word elf = new Word("elf", "elf", "yêu tinh", "elf", "elf", fairytail);
        Word fairy = new Word("fairy", "feə.ri ", "tiên", "fairy", "fairy", fairytail);
        Word giant = new Word("giant", "dʒaɪ.ənt", "người khổng lồ", "giant", "giant", fairytail);
        Word gnome = new Word("gnome", "nəʊm ", "thần lùn giữ của", "gnome", "gnome", fairytail);
        Word king = new Word("king", "kɪŋ", "vua", "king", "king", fairytail);
        Word knight = new Word("knight", "naɪt", "kỵ sĩ", "knight", "knight", fairytail);
        Word leprechaun = new Word("leprechaun", "lep.rɪ.kɔn", "yêu tình(Ai-len)", "leprechaun", "leprechaun", fairytail);
        Word monster = new Word("monster", "mɒnt.stər", "quái vật", "monster", "monster", fairytail);
        Word ogre = new Word("ogre", "əʊ.gər", "yêu tinh ăn thịt người", "ogre", "ogre", fairytail);
        Word prince = new Word("prince", "prɪnts", "công chúa", "prince", "prince", fairytail);
        Word princess = new Word("princess", "prɪnses", "hoàng tử", "bread", "bread", fairytail);
        Word queen = new Word("queen", "kwin", "nữ hoàng", "princess", "princess", fairytail);
        Word scepter = new Word("scepter", "sep.tər", "quyền trượng", "scepter", "scepter", fairytail);
        Word throne = new Word("throne", "θrəʊn", "ngai vàng", "throne", "throne", fairytail);
        Word witch = new Word("witch", "witch", "phù thủy", "witch", "witch", fairytail);
        
        addList.add(castle);
        addList.add(cinderella);
        addList.add(crown);
        addList.add(dragon);
        addList.add(dwarf);
        addList.add(elf);
        addList.add(fairy);
        addList.add(giant);
        addList.add(gnome);
        addList.add(king);
        addList.add(knight);
        addList.add(leprechaun);
        addList.add(monster);
        addList.add(ogre);
        addList.add(prince);
        addList.add(princess);
        addList.add(queen);
        addList.add(scepter);
        addList.add(throne);
        addList.add(witch);
        
        /*5. Emotion*/
        
        Topic emotion = new Topic(5,"emotion", "emotion", null);
        Word afraid = new Word("afraid", "əfreɪd ", "sợ hãi", "afraid", "afraid", emotion);
        Word angry = new Word("angry", "æŋ.gri ", "tức giận", "angry", "angry", emotion);
        Word ashamed = new Word("ashamed", "əʃeɪmd ", "hổ thẹn", "ashamed", "ashamed", emotion);
        Word bored = new Word("bored", "bɔ:d", " ", "chán", "bored", emotion);
        Word courageous = new Word("courageous", "kəreɪ.dʒəs", "can đảm, dũng cảm", "courageous", "courageous", emotion);
        Word cruel = new Word("cruel", "kru.əl", "thô bạo, thô lỗ", "cruel", "cruel", emotion);
        Word disgusted = new Word("disgusted", "dɪsgʌs.tɪd", "chán ghét, ghê tởm", "disgusted", "disgusted", emotion);
        Word excited = new Word("excited", "ɪksaɪ.tɪd", "thích thú", "excited", "excited", emotion);
        Word frustrated = new Word("frustrated", "frʌstreɪ.tɪd", "ức chế", "frustrated", "frustrated", emotion);
        Word happy = new Word("happy", "hæp.i", "hạnh phúc, vui vẻ", "happy", "happy", emotion);
        Word love = new Word("love", "lʌv", "đang yêy", "love", "love", emotion);
        Word mad = new Word("mad", "mæd", "điên rồ", "mad", "mad", emotion);
        Word overwhelmed = new Word("overwhelmed", "əʊ.vəwelm", "không kiềm chế được", "overwhelmed", "overwhelmed", emotion);
        Word proud = new Word("proud", "praʊd", "tự hào", "proud", "proud", emotion);
        Word respectful = new Word("respectful", "rɪspekt.fəl", "kính trọng", "respectful", "respectful", emotion);
        Word rude = new Word("rude", "ru:d", "thô lỗ", "rude", "rude", emotion);
        Word sad = new Word("sad", "sæd", "buồn", "sad", "sad", emotion);
        Word scared = new Word("scared", "skeəd", "sợ hãi", "scared", "scared", emotion);
        Word shy = new Word("shy", "ʃaɪ", "xấu hổ", "shy", "shy", emotion);
        Word stressed = new Word("stressed", "strest", "căng thẳng", "stressed", "stressed", emotion);
        Word surprised = new Word("surprised", "bred", "ngạc nhiên", "surprised", "surprised", emotion);
        Word tired = new Word("tired", "taɪəd", "mệt mỏi", "tired", "tired", emotion);
       
        addList.add(afraid);
        addList.add(angry);
        addList.add(ashamed);
        addList.add(bored);
        addList.add(courageous);
        addList.add(disgusted);
        addList.add(excited);
        addList.add(frustrated);
        addList.add(happy);
        addList.add(love);
        addList.add(mad);
        addList.add(overwhelmed);
        addList.add(proud);
        addList.add(respectful);
        addList.add(rude);
        addList.add(sad);
        addList.add(scared);
        addList.add(shy);
        addList.add(cruel);
        addList.add(stressed);
        addList.add(surprised);
        addList.add(tired);
       
        /*6. Family*/
        Topic family = new Topic(6,"family", "family", null);
        
        Word aunt = new Word("aunt", "ɑnt  ", "cô, dì, thím, mợ", "aunt", "aunt", family);
        Word baby = new Word("baby", "beɪ.bi ", "trẻ con", "baby", "baby", family);
        Word bride = new Word("bride", "braɪd ", "cô dâu", "bride", "bride", family);
        Word brother = new Word("brother", "brʌð.ər ", "anh trai, em trai", "brother", "brother", family);
        Word daughter = new Word("daughter", "dɔ.tər ", "con gái", "daughter", "daughter", family);
        Word father = new Word("father", "fɑ.ðər ", "bố", "father", "father", family);
        Word granddaughter = new Word("granddaughter", "grænd.dɔ.tər ", "cháu gái", "granddaughter", "granddaughter", family);
        Word grandfather = new Word("grandfather", "grænd.fɑ.ðər ", "ông", "grandfather", "grandfather", family);
        Word grandmother = new Word("grandmother", "grænd.mʌð.ər ", "bà", "grandmother", "grandmother", family);
        Word grandson = new Word("grandson", "grænd.sʌn ", "cháu", "grandson", "grandson", family);
        Word groom = new Word("groom", "grum", "chú rể", "groom", "groom", family);
        Word mother = new Word("mother", "mʌð.ə r   ", "mẹ", "mother", "mother", family);
        Word nephew = new Word("nephew", "nef.ju ", "cháu trai", "nephew", "nephew", family);
        Word niece = new Word("niece", "ni:s ", "cháu gái", "niece", "niece", family);
        Word sibling = new Word("sibling", "sɪb.lɪŋ ", "anh, chị em ruột", "sibling", "sibling", family);
        Word sister = new Word("sister", "sɪs.tər", "chị gái, em gái", "sister", "sister", family);
        Word son = new Word("son", "sʌn ", "con", "son", "son", family);
        Word twin = new Word("twin", "twɪn ", "sinh đôi", "twin", "twin", family);
        Word uncle = new Word("uncle", "ʌŋ.kl", "chú, bác", "uncle", "uncle", family);
        
        addList.add(aunt);
        addList.add(baby);
        addList.add(bride);
        addList.add(brother);
        addList.add(daughter);
        addList.add(father);
        addList.add(granddaughter);
        addList.add(grandfather);
        addList.add(grandmother);
        addList.add(grandson);
        addList.add(groom);
        addList.add(sibling);
        addList.add(sister);
        addList.add(son);
        addList.add(twin);
        addList.add(uncle);
        addList.add(mother);
        addList.add(nephew);
        addList.add(niece);
        
        /*7. Holiday*/
        Topic holiday = new Topic(7,"holiday", "holiday", null);
        Word anniversary = new Word("anniversary", "æn.ɪvɜ.sər.i", "lễ kỉ niệm ",holiday);
        Word balloon = new Word("balloon", "bəlun", "bóng bay",holiday);
        Word card = new Word("card", "kɑd", "thiệp chúc mừng",holiday);
        Word birthday = new Word("birthday", "bɜ:θdeɪ ", "sinh nhật",holiday);
        Word bouquet = new Word("bouquet", "bʊkeɪ", "bó hoa",holiday);
        Word bridesmaid = new Word("bridesmaid", "braɪdz.meɪd", "phù dâu",holiday);
        Word christmas = new Word("christmas", "krɪs.məs", "giáng sinh",holiday);
        Word confetti = new Word("confetti", "kənfet.i", "hoa giấy",holiday);
        Word celebration = new Word("celebration", "sel.ɪbreɪ.ʃən", "lễ kỉ niệm",holiday);
        Word firework = new Word("firework", "faɪə.wɜk", "pháo hoa",holiday);
        Word mask = new Word("mask", "mɑ:sk", "mặt nạ",holiday);
        Word eve = new Word("newyearseve", "njujɪəziv", "giao thừa",holiday);
        Word ornament = new Word("ornament", "ɔ:nə.mənt", "đồ trang sức",holiday);
        Word party = new Word("party", "pɑ:ti", "bữa tiệc",holiday);
        Word present = new Word("present", "prez.ənt", "món quà",holiday);
        Word priest = new Word("priest", "pri:st", "thầy tu",holiday);
        Word santa = new Word("Santa Claus ", "sæn.təklɔz", "ông già No-en",holiday);
        Word thanksgiving = new Word("thanksgiving", "θæŋksgɪv.ɪŋ", "lễ tạ ơn",holiday);
       
        Word wrap = new Word("wrap", "/ræp ", "gói quà",holiday);
        Word wedding = new Word("wedding", "wed.ɪŋ", "đám cưới",holiday);
        
        addList.add(anniversary);
        addList.add(balloon);
        addList.add(card);
        addList.add(birthday);
        addList.add(bouquet);
        addList.add(bridesmaid);
        addList.add(christmas);
        addList.add(confetti);
        addList.add(celebration);
        addList.add(firework);
        addList.add(mask);
        addList.add(ornament);
        addList.add(party);
        addList.add(present);
        addList.add(eve);
        addList.add(priest);
        addList.add(santa);
        addList.add(thanksgiving);
 ;
        addList.add(wrap);
        addList.add(wedding);
        
        /*8. Body*/
        
        Topic body = new Topic(8,"body", "body", null);
        Word arm = new Word("arm", "ɑ:m", "cánh tay",body);
        Word calf = new Word("calf", "kɑ:f", "bắp chân",body);
        Word cheek = new Word("cheek", "tʃi:k", "má",body);
        Word chin = new Word("chin", "tʃɪn ", "cằm",body);
        Word ear = new Word("ear", "ɪr ", "tai",body);
        Word elbow = new Word("elbow", "el.bəʊ", "cùi trỏ",body);
        Word eye = new Word("eye", "aɪ ", "mắt",body);
        Word eyebrow = new Word("eyebrow", "aɪ.braʊ", "lông mày",body);
        Word eyelash = new Word("eyelash", "aɪ.læʃ", "lông mi",body);
        
        Word fist = new Word("fist", "fɪst", "nắm đấm",body);
        Word foot = new Word("foot", "fʊt ", "bàn chân",body);
        Word forehead = new Word("forehead", "fɒr.ɪd", "trán",body);
        Word gum = new Word("gum", "gʌm", "lợi",body);
        Word hair = new Word("hair", "heər", "tóc",body);
        Word hand = new Word("hand", "hænd", "bàn tay",body);
        Word heel = new Word("heel", "hil", "gót chân",body);
        Word iris = new Word("iris", "aɪ.rɪs", "con ngươi",body);
        Word knee = new Word("knee", "ni:", "xương bánh chè",body);
        Word leg = new Word("leg", "leg", "chân",body);
        Word lip = new Word("lip", "lɪp ", "môi",body);
        Word muscle = new Word("muscle", "", "cơ bắp",body);
        Word mustache = new Word("mustache", "mʌs.l", "ria mép",body);
        Word nail = new Word("nail", "neɪl", "móng chân, móng tay",body);
        Word neck = new Word("neck", "nek ", "cổ",body);
        Word nose = new Word("nose", "nəʊz", "mũi",body);
        Word palm = new Word("palm", "pɑm", "bàn tay",body);
        Word pupil = new Word("pupil", "pju.pəl", "đồng tử, mắt",body);
        Word shoulder = new Word("shoulder", "ʃəʊl.dər", "vai",body);
        Word sideburns = new Word("sideburns", "saɪd.bɜnz", "râu quai nón",body);
        Word skeleton = new Word("skeleton", "skel.ɪ.tən", "bộ xương",body);
        Word skull = new Word("skull", "skʌl", "đầu lâu",body);
        Word thigh = new Word("thigh", "θaɪ ", "đùi",body);
        Word tooth = new Word("tooth", "tuθ", "răng",body);

        addList.add(arm);addList.add(calf);addList.add(cheek);addList.add(chin);addList.add(ear);
        addList.add(elbow);addList.add(eye);addList.add(eyebrow);addList.add(eyelash);
        addList.add(fist);addList.add(gum);addList.add(heel);addList.add(leg);
        addList.add(foot);addList.add(hair);addList.add(iris);addList.add(lip);
        addList.add(forehead);addList.add(hand);addList.add(knee);addList.add(muscle);
        addList.add(mustache);addList.add(nail);addList.add(neck);addList.add(nose);
        addList.add(palm);addList.add(pupil);addList.add(shoulder);addList.add(sideburns);
        addList.add(skeleton);addList.add(skull);addList.add(thigh);addList.add(tooth);
       
        /*9.job*/
        Topic job = new Topic(9,"job", "job", null);
        Word artist = new Word("artist", "ɑ:tɪst", "nghệ sĩ",job);
        Word astronaut = new Word("astronaut", "æs.trə.nɔt ", "phi hành gia",job);
        Word astronomer = new Word("astronomer", "əstrɒn.ə.mər", "nhà thiên văn học",job);
        Word barber = new Word("barber", "bɑ:bər", "thợ cạo râu, cắt tóc",job);
        Word businessman = new Word("businessman", "bɪz.nɪs.mən", "doanh nhân",job);
        Word carpenter = new Word("carpenter", "kɑ:pɪn.tər", "thợ mộc",job);
        Word cashier = new Word("cashier", "kæʃɪər", "nhân viên thu ngân",job);
        Word chef = new Word("chef", "ʃef", "đầu bếp",job);
        Word coach = new Word("coach", "kəʊtʃ ", "huần luyện viên",job);
        Word conductor = new Word("conductor", "kəndʌk.tər ", "người bán vé, nhạc trưởng",job);
        
        addList.add(artist);
        addList.add(astronaut);
        addList.add(astronomer);
        addList.add(barber);
        addList.add(businessman);
        addList.add(carpenter);
        addList.add(cashier);
        addList.add(chef);
        addList.add(coach);
        addList.add(conductor);

        Word dentist = new Word("dentist", "den.tɪst", "nha sĩ",job);
        Word fireman = new Word("fireman", "faɪə.mən", "lính cứu hỏa",job);
        Word hairdresser = new Word("hairdresser", "heədres.ər", "nhà tạo mẫu tóc",job);
        Word judge = new Word("judge", "dʒʌdʒ", "thẩm phán",job);
        Word librarian = new Word("librarian", "laɪbreə.ri.ən", "thủ thư",job);
        Word lifeguard = new Word("lifeguard", "laɪf.gɑd", "bảo vệ",job);
        Word mailman = new Word("mailman", "meɪl.mæn", "nhân viên đưa thư",job);
        Word mechanic = new Word("mechanic", "məkæn.ɪk ", "thợ sửa cơ khí",job);
        Word nurse = new Word("nurse", "nɜs", "y tá",job);
        Word pilot = new Word("pilot", "paɪ.lət ", "phi công",job);
        
        addList.add(dentist);
        addList.add(fireman);
        addList.add(hairdresser);
        addList.add(judge);
        addList.add(librarian);
        addList.add(lifeguard);
        addList.add(mailman);
        addList.add(mechanic);
        addList.add(nurse);
        addList.add(pilot);


        Word policeman = new Word("policeman", "pəlis:mən", "cảnh sát",job);
        Word referee = new Word("referee", "ref.əri:", "trọng tài",job);
        Word sailor = new Word("sailor", "seɪ.lər", "thủy thủ",job);
        Word scubadiver = new Word("scubadiver", "sku.bədaɪ.vər", "thợ lặn",job);
        Word singer = new Word("singer", "sɪŋ.ər", "ca sĩ",job);
        Word skydiver = new Word("skydiver", "skaɪdaɪ.vər", "người nhảy dù",job);
        Word surgeon = new Word("surgeon", "sɜ:dʒən ", "bác sĩ phẫu thuật",job);
        Word teacher = new Word("teacher", "ti:tʃər", "giáo viên",job);
        Word veterinarian = new Word("veterinarian", "vet.ər.ɪneə.ri.ən", "nhà dinh dưỡng ăn kiêng",job);
        Word waiter = new Word("waiter", "weɪ.tər", "bồi bàn nam",job);
        Word waitress = new Word("waitress", "weɪ.trəs", "bồi bàn nữ",job);
        
        addList.add(policeman);
        addList.add(referee);
        addList.add(sailor);
        addList.add(scubadiver);
        addList.add(skydiver);
        addList.add(singer);
        addList.add(surgeon);
        addList.add(teacher);
        addList.add(veterinarian);
        addList.add(waiter);
        addList.add(waitress);
        
        Word accountant = new Word("accountant", "əkaʊn.tənt", "nhân viên kế toán",job);
        Word architect = new Word("architect", "ɑ.kɪ.tekt ", "kiến trúc sư",job);
        Word assembler = new Word("assembler", "əsem.blər", "nhân viên lắp ráp",job);
        Word baker = new Word("baker", "beɪ.kər", "người làm bánh",job);
        Word boss = new Word("boss", "bɑs", "ông chủ",job);
        Word doctor = new Word("doctor", "dɒk.tər", "bác sỹ",job);
        Word electrician = new Word("electrician", "ɪl.ektrɪʃ.ən", "thợ điện",job);
        Word farmer = new Word("farmer", "fɑ.mər", "nông dan",job);
        Word fisherman = new Word("fisherman", "fɪʃ.ə.mən ", "ngư dân",job);
        Word guard = new Word("guard", "gɑ:d", "bảo vệ",job);
        
        addList.add(accountant);addList.add(architect);
        addList.add(assembler);addList.add(baker);
        addList.add(boss);addList.add(doctor);
        addList.add(electrician);addList.add(farmer);
        addList.add(fisherman);addList.add(guard);
        
        Word journalist = new Word("journalist", "dʒɜ.nə.lɪst", "nhà báo",job);
        Word lawyer = new Word("lawyer", "lɔɪ.ər", "luật sư",job);
        Word maid = new Word("maid", "meɪd", "nhân viên khách sạn",job);
        Word mason = new Word("mason", "meɪ.sə n", "thợ xây",job);
        Word messenger = new Word("messenger", "mes.ɪn.dʒər", "người đưa thư",job);
        Word model = new Word("model", "mɒd.əl", "người mẫu",job);
        Word ninja = new Word("ninja", "nɪn.dʒə", "ninja",job);
        Word painter = new Word("painter", "peɪn.tər", "thợ sơn",job);
        Word robber = new Word("robber", "rɒb.ər", "đạo tặc",job);
        Word salesman = new Word("salesman", "seɪlz.mən", "nhân viên bán hàng",job);
        
        addList.add(journalist);addList.add(lawyer);
        addList.add(maid);addList.add(mason);
        addList.add(messenger);addList.add(model);
        addList.add(ninja);addList.add(painter);
        addList.add(robber);addList.add(salesman);
        
        
        Word scientist = new Word("scientist", "saɪən.tɪst", "nhà nghiên cứu",job);
        Word soldier = new Word("soldier", "səʊl.dʒər", "chiến sĩ",job);
        Word student = new Word("student", "stju.dənt", "sinh viên",job);
        Word tailor = new Word("tailor", "teɪ.lər", "thợ may",job);
        Word welder = new Word("welder", "wel.dər", "thợ kim hoàn",job);
        
        addList.add(scientist);addList.add(tailor);
        addList.add(soldier);addList.add(welder);
        addList.add(student);
        
   
      /*  10.Sport*/
        Topic sport = new Topic(10,"sport", "sport", null);
        
        Word badminton = new Word("badminton", "bæd.mɪn.tən", "cầu lông",sport);
        Word ball = new Word("ball", "bɔ:l", "quả bóng",sport);
        Word baseball = new Word("baseball", "beɪs.bɔ:l", "bóng chày",sport);
        Word basketball = new Word("basketball", "bɑ:skɪt.bɔl", "bóng rổ",sport);
        
        Word birdie = new Word("birdie", "bɜ:di", "quả cầu",sport);
        Word catcher = new Word("catcher", "kætʃ.ər", "người bắt bóng(bóng chày)",sport);
        Word cup = new Word("cup", "kʌp", "cúp",sport);
        Word cycling = new Word("cycling", "saɪ.klɪŋ ", "đua xe đạp",sport);
        Word football = new Word("football", "fʊt.bɔ:l", "bóng đá",sport);
        Word footballer = new Word("footballer", "fʊt.bɔ:lər", "cầu thủ bóng đá",sport);
        
        addList.add(badminton);addList.add(catcher);
        addList.add(ball);addList.add(cup);
        addList.add(baseball);addList.add(cycling);
        addList.add(basketball);addList.add(football);
        addList.add(footballer);
        addList.add(birdie);
        
        Word goalkeeper = new Word("goalkeeper", "gəʊlki:pər", "thủ môn",sport);
        Word golf = new Word("golf", "gɑ:lf", "đánh golf",sport);
        Word gymnastics = new Word("gymnastics", "dʒɪmnæs.tɪks", "thể dục dụng cụ",sport);
        Word helmet = new Word("helmet", "hel.mət", "mũ bảo hiểm",sport);
        Word hockey = new Word("hockey", "hɒk.i", "khúc côn cầu",sport);
        Word judo = new Word("judo", "dʒu:dəʊ", "judo",sport);
        Word karate = new Word("karate", "kərɑ:ti", "karate",sport);
        Word medal = new Word("medal", "med.əl", "huy chương",sport);
        Word net = new Word("net", "net ", "lưới",sport);
        Word pitcher = new Word("pitcher", "pɪtʃ.ər", "người ném bóng(bóng chày)",sport);
        Word race = new Word("race", "reɪs ", "cuộc đua",sport);
        Word racket = new Word("racket", "ræk.ɪt", "vợt",sport);
        
        addList.add(goalkeeper);addList.add(karate);
        addList.add(golf);addList.add(medal);
        addList.add(gymnastics);addList.add(net);
        addList.add(helmet);addList.add(pitcher);
        addList.add(hockey);addList.add(race);
        addList.add(judo);addList.add(racket);
        
        Word run = new Word("run", "rʌn", "chạy",sport);
        Word scubadiving = new Word("scubadiving", "sku.bədaɪ.vɪŋ", "lặn",sport);
        Word skiing = new Word("skiing", "ski:ɪŋ", "trượt tuyết",sport);
        Word skydiving = new Word("skydiving", "skaɪdaɪ.vɪŋ", "nhảy dù tự do",sport);
        Word soccer = new Word("soccer", "sɒk.ər", "bóng đá",sport);
        Word stadium = new Word("stadium", "steɪ.di.əm", "sân vận động",sport);
        Word surfing = new Word("surfing", "sɜ:fɪŋ", "lướt sóng",sport);
        Word swimming = new Word("swimming", "swɪmɪŋ", "bơi",sport);
        Word tennis = new Word("tennis", "ten.ɪs", "tennis",sport);
        Word volleyball = new Word("volleyball", "vɒl.i.bɔ:l", "bóng chuyền",sport);
        Word wrestling = new Word("wrestling", "res.lɪŋ", "vật",sport);
        
        addList.add(run);addList.add(surfing);
        addList.add(scubadiving);addList.add(swimming);
        addList.add(skiing);addList.add(tennis);
        addList.add(skydiving);addList.add(volleyball);
        addList.add(soccer);addList.add(wrestling);
        addList.add(stadium);
    
        Word aerobic = new Word("aerobic", "eərəʊ.bɪk", "bộ môn aerobic",sport);
        Word billiards = new Word("billiards", "bɪl.i.ədz", "bi a",sport);
        Word boxing = new Word("boxing", "bɒk.sɪŋ", "đấm bốc",sport);
        Word chess = new Word("chess", "tʃes", "cờ vua",sport);
        Word cue = new Word("cue", "kju", "gậy đánh bia",sport);
        Word dancer = new Word("dancer", "dɑn:sər", "vũ công",sport);
        Word dart = new Word("dart", "dɑ:rt", "ném phi tiêu",sport);
        Word fishing = new Word("fishing", "fɪʃ.ɪŋ", "câu cá",sport);
        Word goggles = new Word("goggle", "gɒg.lz", "kính bơi",sport);
        Word hiking = new Word("hiking", "haɪ.kɪŋ", "đi bộ đường dài",sport);
        
        addList.add(aerobic);addList.add(billiards);
        addList.add(boxing);addList.add(chess);
        addList.add(cue);addList.add(fishing);
        addList.add(dart);addList.add(dancer);
        addList.add(goggles);addList.add(hiking);
        
        Word matador = new Word("matador", "mæt.ə.dɔr", "dũng sĩ đấu bò",sport);
        Word ribbon = new Word("ribbon", "rɪb.ə n", "dây băng",sport);
        Word rugby = new Word("rugby", "rʌg.bi", "bóng bầu dục",sport);
        Word stopwatch = new Word("stopwatch", "stɒp.wɒtʃ", "đồng hồ bấm giờ",sport);
        Word surfboard = new Word("surfboard", "sɜf.bɔd", "ván lướt sóng",sport);
        Word torch = new Word("torch", "tɔtʃ ", "ngọn đuốc",sport);
        Word trampoline = new Word("trampoline", "træm.pə l.in", "tấm bạt lò xo",sport);
     
        addList.add(matador);addList.add(ribbon);
        
        addList.add(rugby);addList.add(stopwatch);
        
        addList.add(surfboard);addList.add(torch);
        
        addList.add(trampoline);
        ;
        
        /*
        11. Transportation*/
        Topic transportaion = new Topic(11,"transportaion", "transportaion", null);
        
        Word airplane = new Word("airplane", "eə.pleɪn", "máy bay",transportaion);
        Word airport = new Word("airport", "eə.pɔ:t", "sân bay",transportaion);
        Word anchor = new Word("anchor", "æŋ.kər", "mỏ neo",transportaion);
        Word backpack = new Word("backpack", "bæk.pæk", "ba lô",transportaion);
        Word battery = new Word("battery", "bæt.ər.i", "pin",transportaion);
        Word boat = new Word("boat", "bəʊt", "thuyền",transportaion);
        Word bus = new Word("bus", "bʌs", "xe buýt",transportaion);
        Word car = new Word("car", "kɑ:r", "xe ô tô",transportaion);
        Word engine = new Word("engine", "en.dʒɪn", "động cơ",transportaion);
        Word garage = new Word("garage", "gær.ɑʒ ", "gara",transportaion);
        Word helicopter = new Word("helicopter", "hel.ɪkɒp.tər", "trực thăng",transportaion);
        Word kayak = new Word("kayak", "kaɪ.æk", "xuồng caiac",transportaion);
        addList.add(airplane);addList.add(bus);
        addList.add(airport);addList.add(car);
        addList.add(anchor);addList.add(engine);
        addList.add(backpack);addList.add(garage);
        addList.add(battery);addList.add(helicopter);
        addList.add(boat);addList.add(kayak);
        
        Word luggage = new Word("luggage", "lʌg.ɪdʒ", "hành lý",transportaion);
        Word parachute = new Word("parachute", "pær.ə.ʃut", "dù",transportaion);
        Word plane = new Word("plane", "pleɪn", "máy bay",transportaion);
        Word railroad = new Word("railroad", "reɪl.rəʊd", "đường ray",transportaion);
        Word road = new Word("road", "rəʊd ", "đường phố",transportaion);
        Word sailboat = new Word("sailboat", "seɪlbəʊt ", "thuyền buồm",transportaion);
        Word ship = new Word("ship", "ʃɪp ", "du thuyền",transportaion);
        Word shop = new Word("shop", "ʃɑp ", "cửa hàng",transportaion);
        Word street = new Word("street", "strit ", "đường phố",transportaion);
        addList.add(luggage);addList.add(ship);
        addList.add(parachute);addList.add(shop);
        addList.add(plane);addList.add(street);
        addList.add(railroad);
        addList.add(road);
        addList.add(sailboat);
        
        Word subway = new Word("subway", "sʌb.weɪ ", "đường ngầm",transportaion);
        Word suitcase = new Word("suitcase", "sjut.keɪs", "vali",transportaion);
        Word tanker = new Word("tanker", "tæŋ.kə r  ", "xe chở dầu",transportaion);
        Word taxi = new Word("taxi", "tæk.si ", "taxi",transportaion);
        Word tire = new Word("tire", "taɪər", "lốp xe",transportaion);
        Word traffic = new Word("traffic", "træf.ɪk ", "giao thông",transportaion);
        Word train = new Word("train", "treɪn ", "xe lửa",transportaion);
        Word truck = new Word("truck", "trʌk ", "xe tải",transportaion);
        Word trunk = new Word("trunk", "trʌŋk ", "cốp xe",transportaion);
        Word tunnel = new Word("tunnel", "tʌn.əl", "đường hầm",transportaion);
        Word van = new Word("van", "væn ", "xe hành lý",transportaion);
        Word wheel = new Word("wheel", "wil", "bánh xe",transportaion);
        addList.add(subway);addList.add(train);
        addList.add(suitcase);addList.add(truck);
        addList.add(tanker);addList.add(trunk);
        addList.add(taxi);addList.add(tunnel);
        addList.add(tire);addList.add(van);
        addList.add(traffic);addList.add(wheel);
        
/*        12. Wheather*/
        Topic wheather = new Topic(12,"wheather", "wheather", null);
        
        Word autumn = new Word("autumn", "ɔ:təm", "mùa thu",wheather);
        Word cold = new Word("cold", "kəʊld", "lạnh",wheather);
        Word day = new Word("day", "deɪ", "ngày",wheather);
        Word dew = new Word("dew", "dju", "sương",wheather);
        Word drought = new Word("drought", "draʊt ", "hạn hán",wheather);
        Word flood = new Word("flood", "flʌd", "lũ lụt",wheather);
        Word fog = new Word("fog", "fɒg", "sương mù",wheather);
        Word freezing = new Word("freezing", "fri.zɪŋ", "đông cứng",wheather);
        Word frost = new Word("frost", "frɒst", "sương giá",wheather);
        Word hot = new Word("hot", "hɒt", "nóng",wheather);
        
        addList.add(autumn);addList.add(flood);
        addList.add(cold);addList.add(fog);
        addList.add(day);addList.add(freezing);
        addList.add(dew);addList.add(frost);
        addList.add(drought);addList.add(hot);
        
        Word ice = new Word("ice", "aɪs", "băng",wheather);
        Word lightning = new Word("lightning", "laɪt.nɪŋ ", "sét",wheather);
        Word mist = new Word("mist", "mɪst", "sương mù",wheather);
        Word night = new Word("night", "naɪt", "đêm",wheather);
        Word rain = new Word("rain", "reɪn", "mưa",wheather);
        Word rainbow = new Word("rainbow", "reɪn.bəʊ", "cầu vồng",wheather);
        Word snowflake = new Word("snowflake", "snəʊ.fleɪk", "bông tuyết",wheather);
        Word snow = new Word("snow", "snəʊ", "tuyết",wheather);
        Word snowman = new Word("snowman", "snəʊ.mæn", "người tuyết",wheather);
        Word spring = new Word("spring", "sprɪŋ", "mùa xuân",wheather);
        
        addList.add(ice);addList.add(lightning);
        addList.add(mist);addList.add(night);
        addList.add(rain);addList.add(rainbow);
        addList.add(snowflake);addList.add(snow);
        addList.add(snowman);addList.add(spring);
        
        Word summer = new Word("summer", "sʌm.ə r", "mùa hè",wheather);
        Word sunny = new Word("sunny", "sʌn.i", "trời nắng",wheather);
        Word sunrise = new Word("sunrise", "sʌn.raɪz", "mặt trời mọc",wheather);
        Word sunset = new Word("sunset", "sʌn.set", "mặt trời lặn",wheather);
        Word thermometer = new Word("thermometer", "θəmɒm.ɪ.tə r", "nhiệt kế",wheather);
        Word thunderstorm = new Word("thunderstorm", "θʌn.də.stɔm", "dông bão",wheather);
        Word tornado = new Word("tornado", "tɔneɪ.dəʊ", "vòi rồng",wheather);
        Word tsunami = new Word("tsunami", "tsunɑ.mi", "sóng thần",wheather);
        Word warm = new Word("warm", "wɔ:m", "ấm",wheather);
        Word windy = new Word("windy", "wɪn.di", "trời có gió mạnh",wheather);
        Word winter = new Word("winter", "wɪn.tər", "mùa đông",wheather);
        
        addList.add(summer);addList.add(sunny);
        addList.add(sunrise);addList.add(sunset);
        addList.add(thermometer);addList.add(thunderstorm);
        addList.add(tornado);addList.add(tsunami);
        addList.add(warm);addList.add(windy);
        addList.add(winter);

		TopicMapper topicMaper = new TopicMapper(context);
		// Insert WordList into database
		for (Word aWord : addList){
			topicMaper.addWord(aWord);
		}
		
		Log.d("Insert Word", "Word");
	}
	
	public void insertTestdata(){
		TopicMapper tm = new TopicMapper(context);
		
		Topic testTopic = new Topic(100, "test", "test", null);
		tm.add(testTopic);
		
		Word test1 = new Word("test1", "test1", "test1", "test1", "test1", 1, testTopic, 2);
		Word test2 = new Word("test2", "test2", "test2", "test2", "test2", 1, testTopic, 5);
		Word test3 = new Word("test3", "test3", "test3", "test3", "test3", 1, testTopic, 1);
		List<Word> addList = new ArrayList<Word>();
		 addList.add(test1);
		 addList.add(test2);
		 addList.add(test3);
		 
		 for (Word aWord : addList){
			 tm.addTestWord(aWord);
			}
		 Log.d("Insert test data", "insert test data");
	}
	
}
