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
        Word fish = new Word("fish", "fɪʃ", "cá", "fish", "fish", food);
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
        addList.add(fish);
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
        
        
        Word afraid = new Word("afraid", "əfreɪd ", "sợ hãi", "afraid", "afraid", fairytail);
        Word angry = new Word("angry", "æŋ.gri ", "tức giận", "angry", "angry", fairytail);
        Word ashamed = new Word("ashamed", "əʃeɪmd ", "hổ thẹn", "ashamed", "ashamed", fairytail);
        Word bored = new Word("bored", "bɔ:d", " ", "chán", "bored", fairytail);
        Word courageous = new Word("kəreɪ.dʒəs", "bred", "can đảm, dũng cảm", "courageous", "courageous", fairytail);
        Word cruel = new Word("bread", "kru.əl", "thô bạo, thô lỗ", "cruel", "cruel", fairytail);
        Word disgusted = new Word("disgusted", "dɪsgʌs.tɪd", "chán ghét, ghê tởm", "disgusted", "disgusted", fairytail);
        Word excited = new Word("excited", "ɪksaɪ.tɪd", "thích thú", "excited", "excited", fairytail);
        Word frustrated = new Word("frustrated", "frʌstreɪ.tɪd", "ức chế", "frustrated", "frustrated", fairytail);
        Word happy = new Word("happy", "hæp.i", "hạnh phúc, vui vẻ", "happy", "happy", fairytail);
        Word love = new Word("love", "lʌv", "đang yêy", "love", "love", fairytail);
        Word mad = new Word("mad", "mæd", "điên rồ", "mad", "mad", fairytail);
        Word overwhelmed = new Word("overwhelmed", "əʊ.vəwelm", "không kiềm chế được", "overwhelmed", "overwhelmed", fairytail);
        Word proud = new Word("proud", "praʊd", "tự hào", "proud", "proud", fairytail);
        Word respectful = new Word("respectful", "rɪspekt.fəl", "kính trọng", "respectful", "respectful", fairytail);
        Word rude = new Word("rude", "ru:d", "thô lỗ", "rude", "rude", fairytail);
        Word sad = new Word("sad", "sæd", "buồn", "sad", "sad", fairytail);
        Word scared = new Word("scared", "skeəd", "sợ hãi", "scared", "scared", fairytail);
        Word shy = new Word("shy", "ʃaɪ", "xấu hổ", "shy", "shy", fairytail);
        Word stressed = new Word("stressed", "strest", "căng thẳng", "stressed", "stressed", fairytail);
        Word surprised = new Word("surprised", "bred", "ngạc nhiên", "surprised", "surprised", fairytail);
        Word tired = new Word("tired", "taɪəd", "mệt mỏi", "tired", "tired", fairytail);
       
        addList.add(afraid);
        addList.add(angry);
        addList.add(ashamed);
        addList.add(bored);
        addList.add(courageous);
        addList.add(disgusted);
        addList.add(excited);
        addList.add(frustrated);
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
        Word turkey = new Word("turkey", "tɜ.ki", "gà tây",holiday);
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
        addList.add(turkey);
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
        Word forehead = new Word("foot", "fɒr.ɪd", "trán",body);
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
        Word tooth = new Word("tooth", "tuθ", "răng",body);
        Word tooth = new Word("tooth", "tuθ", "răng",body);
        Word tooth = new Word("tooth", "tuθ", "răng",body);
        Word tooth = new Word("tooth", "tuθ", "răng",body);
        Word tooth = new Word("tooth", "tuθ", "răng",body);
        Word tooth = new Word("tooth", "tuθ", "răng",body);
        Word tooth = new Word("tooth", "tuθ", "răng",body);
        Word tooth = new Word("tooth", "tuθ", "răng",body);
        Word tooth = new Word("tooth", "tuθ", "răng",body);
        Word tooth = new Word("tooth", "tuθ", "răng",body);

        Word tooth = new Word("tooth", "tuθ", "răng",body);
        Word tooth = new Word("tooth", "tuθ", "răng",body);
        Word tooth = new Word("tooth", "tuθ", "răng",body);
        Word tooth = new Word("tooth", "tuθ", "răng",body);
        Word tooth = new Word("tooth", "tuθ", "răng",body);
        Word tooth = new Word("tooth", "tuθ", "răng",body);
        Word tooth = new Word("tooth", "tuθ", "răng",body);
        Word tooth = new Word("tooth", "tuθ", "răng",body);
        Word tooth = new Word("tooth", "tuθ", "răng",body);
        Word tooth = new Word("tooth", "tuθ", "răng",body);

        Word tooth = new Word("tooth", "tuθ", "răng",body);
        Word tooth = new Word("tooth", "tuθ", "răng",body);
        Word tooth = new Word("tooth", "tuθ", "răng",body);
        Word tooth = new Word("tooth", "tuθ", "răng",body);
        Word tooth = new Word("tooth", "tuθ", "răng",body);
        Word tooth = new Word("tooth", "tuθ", "răng",body);
        Word tooth = new Word("tooth", "tuθ", "răng",body);
        Word tooth = new Word("tooth", "tuθ", "răng",body);
        Word tooth = new Word("tooth", "tuθ", "răng",body);
        Word tooth = new Word("tooth", "tuθ", "răng",body);
        Word tooth = new Word("tooth", "tuθ", "răng",body);
        Word tooth = new Word("tooth", "tuθ", "răng",body);

        
        

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
