package com.skypedal.skypedal_backend.test;

import java.time.LocalDateTime;
import java.util.Calendar;

public class Constants {
    public static final String ROUTE_GEOJSON = "{  \"type\": \"Feature\",  \"geometry\": {    \"type\": \"LineString\",    \"coordinates\": [[55.93909,-3.18689],[55.9395,-3.18704],[55.9396,-3.18711],[55.93952,-3.18827],[55.9395,-3.1893],[55.93959,-3.1906],[55.93968,-3.19124],[55.93974,-3.19166],[55.93983,-3.19254],[55.94007,-3.1942],[55.94017,-3.1946],[55.94022,-3.19483],[55.94013,-3.19515],[55.94011,-3.1954],[55.93916,-3.20038],[55.93877,-3.2025],[55.93867,-3.20299],[55.93851,-3.20359],[55.93831,-3.20418],[55.93774,-3.20562],[55.93759,-3.2059],[55.93758,-3.206],[55.93764,-3.20613],[55.93692,-3.20739],[55.93649,-3.20816],[55.9363,-3.2086],[55.93587,-3.20973],[55.93574,-3.2099],[55.93569,-3.20994],[55.93571,-3.2102],[55.93569,-3.21032],[55.93543,-3.21124],[55.93491,-3.21256],[55.93547,-3.21337],[55.93594,-3.21389],[55.93677,-3.21498],[55.93694,-3.21523],[55.93469,-3.22209],[55.93446,-3.2228],[55.93359,-3.22358],[55.93413,-3.22452],[55.93355,-3.22512],[55.9335,-3.22498],[55.93271,-3.22583],[55.93222,-3.22626],[55.93156,-3.22671],[55.93142,-3.22678],[55.93122,-3.22698],[55.93018,-3.22778],[55.92981,-3.22814],[55.9295,-3.22852],[55.92808,-3.23042],[55.92792,-3.23066],[55.92765,-3.23119],[55.92749,-3.23163],[55.92732,-3.23213],[55.92722,-3.23231],[55.92721,-3.23244],[55.92659,-3.2343],[55.92623,-3.23519],[55.92555,-3.23675],[55.92538,-3.23725],[55.92525,-3.23774],[55.92502,-3.23911],[55.92486,-3.23965],[55.92468,-3.24004],[55.92434,-3.24056],[55.92425,-3.24079],[55.92413,-3.24124],[55.92405,-3.24167],[55.92403,-3.24209],[55.92407,-3.24291],[55.92416,-3.24411],[55.9242,-3.24435],[55.92446,-3.24524],[55.92452,-3.24574],[55.92452,-3.24585],[55.92464,-3.24676],[55.92457,-3.24722],[55.92447,-3.24759],[55.92437,-3.24783],[55.92401,-3.24857],[55.92393,-3.24864],[55.92294,-3.25054],[55.92289,-3.25075],[55.92176,-3.25296],[55.92141,-3.25386],[55.92128,-3.25434],[55.92107,-3.25523],[55.92094,-3.25554],[55.92077,-3.25585],[55.92053,-3.25625],[55.92031,-3.25673],[55.92008,-3.25737],[55.91992,-3.25794],[55.91983,-3.25831],[55.91968,-3.25883],[55.91948,-3.2597],[55.91945,-3.26002],[55.91945,-3.26038],[55.91956,-3.26141],[55.91956,-3.26162],[55.91961,-3.26239],[55.91961,-3.26295],[55.91943,-3.26412],[55.9193,-3.26471],[55.91926,-3.26488],[55.91918,-3.26512],[55.91915,-3.26529],[55.91912,-3.2656],[55.91878,-3.26734],[55.91869,-3.26811],[55.91865,-3.26878],[55.91867,-3.26945],[55.91878,-3.27082],[55.91876,-3.27129],[55.91868,-3.27176],[55.9186,-3.27182],[55.91856,-3.27208],[55.91853,-3.27223],[55.91836,-3.27283],[55.91825,-3.27305],[55.91808,-3.27323],[55.91798,-3.27345],[55.91788,-3.27352],[55.91778,-3.27378],[55.91776,-3.27393],[55.91767,-3.27418],[55.91764,-3.27449],[55.91758,-3.27498],[55.91743,-3.27556],[55.91737,-3.27567],[55.91731,-3.27597],[55.91731,-3.27612],[55.91727,-3.27635],[55.91727,-3.27655],[55.9173,-3.27694],[55.9173,-3.27761],[55.91725,-3.27824],[55.91724,-3.27855],[55.91722,-3.27863],[55.91723,-3.27901],[55.91728,-3.27915],[55.9173,-3.27944],[55.91744,-3.28016],[55.91751,-3.28086],[55.9175,-3.28208],[55.91746,-3.28237],[55.91744,-3.28442],[55.9174,-3.28454],[55.91739,-3.28486],[55.91743,-3.28506],[55.91742,-3.2854],[55.91719,-3.28672],[55.91699,-3.28772],[55.91694,-3.28782],[55.91686,-3.28832],[55.91689,-3.28848],[55.91668,-3.29],[55.91651,-3.29222],[55.9165,-3.29369],[55.91644,-3.29446],[55.91636,-3.29521],[55.91637,-3.29679],[55.91638,-3.29687],[55.91644,-3.29695],[55.91644,-3.2971],[55.9164,-3.29731],[55.91646,-3.2977],[55.9166,-3.29815],[55.91679,-3.29857],[55.91696,-3.29888],[55.91726,-3.29929],[55.91754,-3.29955],[55.92017,-3.30151],[55.92041,-3.30176],[55.92073,-3.30197],[55.92088,-3.30205],[55.92149,-3.30254],[55.92164,-3.30272],[55.92183,-3.30305],[55.92195,-3.30336],[55.92199,-3.30373],[55.92198,-3.30406],[55.9218,-3.30604],[55.92176,-3.30628],[55.92171,-3.30644],[55.92153,-3.308],[55.92154,-3.3081],[55.9215,-3.3083],[55.92146,-3.30847],[55.92146,-3.30871],[55.92112,-3.31055],[55.92102,-3.3109],[55.92093,-3.31116],[55.9209,-3.3115],[55.92022,-3.31523],[55.92012,-3.31589],[55.91997,-3.31713],[55.91974,-3.31932],[55.91951,-3.32098],[55.91939,-3.32159],[55.91938,-3.32188],[55.91928,-3.32241],[55.91905,-3.3233],[55.91873,-3.32426],[55.91854,-3.32539],[55.9179,-3.33015],[55.91761,-3.33203],[55.91759,-3.33227],[55.91763,-3.33288],[55.91769,-3.33331],[55.91771,-3.33387],[55.9177,-3.33427],[55.91747,-3.3365],[55.91735,-3.33729],[55.91721,-3.33788],[55.91689,-3.33884],[55.9168,-3.33935],[55.91679,-3.33985],[55.91684,-3.34026],[55.91713,-3.34187],[55.91714,-3.34205],[55.91723,-3.34237],[55.91763,-3.34444],[55.91809,-3.34698],[55.91843,-3.34858],[55.9186,-3.34907],[55.91909,-3.34988],[55.9198,-3.35095],[55.91991,-3.35122],[55.92013,-3.35145],[55.9229,-3.35474],[55.92394,-3.35597],[55.92442,-3.35667],[55.92451,-3.35683],[55.92474,-3.35746],[55.92488,-3.35802],[55.92495,-3.35886],[55.92498,-3.35993],[55.9249,-3.36214],[55.92479,-3.3644],[55.92472,-3.36507],[55.92454,-3.36597],[55.92433,-3.36688],[55.92422,-3.36767],[55.92405,-3.36989],[55.92383,-3.3721],[55.92378,-3.37264],[55.92377,-3.37314],[55.92378,-3.37337],[55.92371,-3.37444],[55.92357,-3.37563],[55.92357,-3.37591],[55.9236,-3.37618],[55.92396,-3.37734],[55.92398,-3.37757],[55.92398,-3.37774],[55.92403,-3.37779],[55.924,-3.37796],[55.92393,-3.37809],[55.92386,-3.37835],[55.92375,-3.37857],[55.92354,-3.37883],[55.92344,-3.37897],[55.9232,-3.37986],[55.92313,-3.38038],[55.92306,-3.38133],[55.92303,-3.38286],[55.92308,-3.38345],[55.92317,-3.38432],[55.92324,-3.38544],[55.92328,-3.38607],[55.92335,-3.38705],[55.92334,-3.38752],[55.92328,-3.38822],[55.92321,-3.38869],[55.92292,-3.39033],[55.92274,-3.39202],[55.92263,-3.39329],[55.92256,-3.39425],[55.92249,-3.39631],[55.92258,-3.39929],[55.923,-3.40575],[55.92307,-3.40638],[55.92316,-3.40691],[55.92335,-3.40751],[55.9237,-3.40827],[55.92407,-3.40888],[55.92441,-3.40941],[55.9246,-3.40984],[55.92474,-3.41046],[55.92489,-3.41157],[55.92492,-3.41235],[55.92485,-3.41314],[55.92472,-3.41385],[55.92465,-3.41409],[55.92458,-3.41427],[55.92449,-3.41465],[55.92448,-3.41492],[55.92441,-3.41513],[55.92411,-3.41562],[55.92358,-3.41644],[55.92337,-3.41691],[55.922,-3.4205],[55.92183,-3.42119],[55.92178,-3.42154],[55.92176,-3.42257],[55.92173,-3.42285],[55.92162,-3.42338],[55.9212,-3.42516],[55.92111,-3.42543],[55.92059,-3.42783],[55.92054,-3.42813],[55.92055,-3.42849],[55.92069,-3.4292],[55.92072,-3.42947],[55.92071,-3.42984],[55.92075,-3.43007],[55.92074,-3.43048],[55.92066,-3.43097],[55.92055,-3.43131],[55.92046,-3.43153],[55.92019,-3.43201],[55.92012,-3.43219],[55.92009,-3.43246],[55.92014,-3.43285],[55.92016,-3.43294],[55.92018,-3.4332],[55.9205,-3.43465],[55.92058,-3.43486],[55.92071,-3.43526],[55.92082,-3.43551],[55.92123,-3.43615],[55.92281,-3.43849],[55.92292,-3.43873],[55.92301,-3.43898],[55.92308,-3.43932],[55.92306,-3.43958],[55.92307,-3.43964],[55.92293,-3.4397],[55.92283,-3.4399],[55.92246,-3.44106],[55.92221,-3.44168],[55.92172,-3.44322],[55.92156,-3.4439],[55.92153,-3.44419],[55.9215,-3.44435],[55.9214,-3.44567],[55.9214,-3.44768],[55.92138,-3.4481],[55.92125,-3.44916],[55.92093,-3.45166],[55.92009,-3.45478],[55.92002,-3.45489],[55.9198,-3.45499],[55.91973,-3.45513],[55.91935,-3.45658],[55.91912,-3.45716],[55.91907,-3.45735],[55.91904,-3.45775],[55.919,-3.45892],[55.91892,-3.45933],[55.91858,-3.46067],[55.91835,-3.46154],[55.91431,-3.45769],[55.91273,-3.45616],[55.91218,-3.45706],[55.90993,-3.4602],[55.90929,-3.46116],[55.90638,-3.46583],[55.90568,-3.46422],[55.90514,-3.46294],[55.90505,-3.46266],[55.90484,-3.46231],[55.90473,-3.46204],[55.90469,-3.46189],[55.90462,-3.46131],[55.90457,-3.46065],[55.90458,-3.4594],[55.90442,-3.45971],[55.90432,-3.45995],[55.90421,-3.46],[55.90349,-3.45986],[55.90342,-3.46016],[55.90335,-3.46028],[55.90278,-3.46079],[55.902,-3.46172],[55.90156,-3.46224],[55.9015,-3.46229],[55.90126,-3.46237],[55.90122,-3.46239],[55.90113,-3.4629],[55.90106,-3.46299],[55.9005,-3.46299],[55.90036,-3.46303],[55.90024,-3.46316],[55.90021,-3.4632],[55.90019,-3.4634],[55.90003,-3.4638],[55.89966,-3.46465],[55.89956,-3.46499],[55.89946,-3.46549],[55.89943,-3.46586],[55.89948,-3.46628],[55.89948,-3.4667],[55.89952,-3.46733],[55.8996,-3.46785],[55.89975,-3.46845],[55.89971,-3.46854],[55.89934,-3.46879],[55.89934,-3.46892],[55.89955,-3.4703],[55.89958,-3.47084],[55.89959,-3.47128],[55.89947,-3.47235],[55.89928,-3.47327],[55.89912,-3.47384],[55.89892,-3.47437],[55.89869,-3.47488],[55.89861,-3.47504],[55.89849,-3.47517],[55.89815,-3.47532],[55.89714,-3.47562],[55.89681,-3.47576],[55.89678,-3.47567],[55.89615,-3.47596],[55.89597,-3.47602],[55.89583,-3.47601],[55.89578,-3.47609],[55.89563,-3.4761],[55.8955,-3.47617],[55.89513,-3.47698],[55.89475,-3.47791],[55.89472,-3.47803],[55.89535,-3.47833],[55.89538,-3.47864],[55.8952,-3.47863],[55.8951,-3.47887],[55.895,-3.47885],[55.89489,-3.47903],[55.89467,-3.47947],[55.89462,-3.48033],[55.89482,-3.48155],[55.89489,-3.48237],[55.89493,-3.48273],[55.89471,-3.48361],[55.8939,-3.48562],[55.89362,-3.4862],[55.89334,-3.48669],[55.89325,-3.48693],[55.8932,-3.48716],[55.89319,-3.48752],[55.89321,-3.48794],[55.89323,-3.48807],[55.8932,-3.48826],[55.8931,-3.48883],[55.89306,-3.48913],[55.89307,-3.48921],[55.89347,-3.49006],[55.89377,-3.49081],[55.89382,-3.49099],[55.89383,-3.49119],[55.89344,-3.49194],[55.89327,-3.49237],[55.89292,-3.49293],[55.89264,-3.4936],[55.89246,-3.49414],[55.89236,-3.49465],[55.89231,-3.49507],[55.89233,-3.49576],[55.89232,-3.49587],[55.89215,-3.49651],[55.89209,-3.4968],[55.89178,-3.49763],[55.8916,-3.498],[55.89133,-3.49836],[55.89116,-3.49841],[55.8911,-3.49849],[55.89106,-3.49863],[55.89087,-3.49898],[55.88997,-3.5021],[55.88985,-3.50266],[55.88979,-3.50275],[55.88968,-3.503],[55.88956,-3.50367],[55.88922,-3.50429],[55.88912,-3.50456],[55.88897,-3.50484],[55.88887,-3.5052],[55.88884,-3.50573],[55.88876,-3.50609],[55.88873,-3.50624],[55.88865,-3.50674],[55.88864,-3.50723],[55.88867,-3.50789],[55.8886,-3.50833],[55.88858,-3.50846],[55.88852,-3.51032],[55.88843,-3.51107],[55.88839,-3.51143],[55.88825,-3.51201],[55.88776,-3.51258],[55.88749,-3.51262],[55.8873,-3.51277],[55.88692,-3.51327],[55.88685,-3.51339],[55.88673,-3.5137],[55.88668,-3.51401],[55.88663,-3.51459],[55.88636,-3.5162],[55.88632,-3.51649],[55.88656,-3.51655],[55.88672,-3.51666],[55.88691,-3.5169],[55.887,-3.51712],[55.88701,-3.5173],[55.88697,-3.51793],[55.8869,-3.51841],[55.88677,-3.519],[55.8867,-3.51958],[55.88671,-3.51969],[55.88693,-3.51975],[55.88724,-3.51995],[55.88735,-3.52006],[55.88744,-3.52021],[55.88746,-3.52038],[55.88744,-3.52128],[55.88749,-3.52248],[55.8875,-3.52275],[55.88745,-3.52316],[55.88739,-3.52351],[55.88697,-3.52502],[55.88696,-3.52519],[55.88701,-3.52537],[55.88721,-3.52581],[55.88718,-3.52611],[55.88703,-3.52668],[55.8869,-3.52697],[55.88664,-3.52728],[55.88623,-3.52768],[55.88603,-3.52782],[55.88577,-3.52816],[55.88522,-3.52943],[55.88508,-3.52984],[55.88478,-3.53043],[55.88453,-3.53089],[55.88424,-3.53154],[55.88413,-3.53175],[55.88395,-3.53248],[55.88381,-3.53287],[55.8838,-3.53314],[55.88384,-3.53372],[55.88395,-3.53429],[55.88397,-3.53487],[55.88385,-3.53601],[55.88384,-3.5371],[55.88381,-3.53731],[55.88376,-3.53746],[55.88354,-3.53765],[55.8834,-3.53769],[55.88327,-3.53767],[55.88323,-3.53768],[55.88282,-3.53843],[55.8826,-3.53868],[55.88253,-3.53885],[55.8824,-3.53905],[55.8821,-3.53935],[55.88173,-3.53967],[55.88151,-3.53994],[55.88143,-3.54008],[55.88138,-3.54026],[55.88069,-3.5395],[55.88052,-3.53936],[55.88028,-3.53924],[55.88006,-3.53924],[55.87984,-3.53933],[55.87888,-3.54006],[55.87869,-3.5402],[55.87852,-3.54036],[55.87758,-3.54185],[55.8774,-3.54209],[55.87717,-3.54229],[55.87677,-3.54251],[55.87635,-3.54254],[55.8759,-3.5424],[55.87411,-3.54145],[55.87393,-3.54127],[55.87381,-3.54104],[55.87375,-3.54082],[55.87364,-3.54067],[55.87352,-3.54064],[55.87339,-3.54072],[55.87331,-3.54086],[55.87327,-3.54106],[55.87329,-3.54129],[55.87331,-3.54136],[55.87315,-3.54216],[55.87305,-3.54253],[55.87298,-3.54273],[55.8729,-3.54282],[55.87287,-3.54299],[55.8729,-3.54315],[55.87297,-3.54325],[55.87306,-3.54325],[55.87312,-3.5432],[55.87328,-3.54323],[55.87363,-3.54339],[55.87379,-3.54342]]  }}";

    public static final LocalDateTime DATE_REDEEMED = LocalDateTime.of(2024, Calendar.AUGUST, 12, 12, 0);
    public static final LocalDateTime DATE_EXPIRY = LocalDateTime.of(2024, Calendar.AUGUST, 24, 12, 0);
}
