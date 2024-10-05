package com.example.timetable;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button1,button2,button3,button4,button5,button6,button7,button8;
    private RadioButton radioButton1,radioButton2;
    private TextView textView;
    private Spinner spinner,spinnerB;
    private final String[] days={"Monday","Tuesday","Wednesday","Thursday","Friday"};
    private final String[] yr={"2nd year","3rd year","4th year"};
    private final String[][][][] TimeTable={
            {
                    {
                            {"ESP-IV, CHM, LG3.1","EVS, VP, LG3.1","COA, TS, LG3.1", "OOPs, ADB, LG3.1","C1-COA Lab;C2- OOPs Lab, C1-TS,SJ,SOB;C2-AP,AYC,ANM, C1-L.G-4.1;C2- Zone 3 and Zone 4","C1-COA Lab;C2- OOPs Lab, C1-TS,SJ,SOB;C2-AP,AYC,ANM, C1-L.G-4.1;C2- Zone 3 and Zone 4","C1-COA Lab;C2- OOPs Lab, C1-TS,SJ,SOB;C2-AP,AYC,ANM, C1-L.G-4.1;C2- Zone 3 and Zone 4","Innovative Project,LG3.1"},//Monday
                            {"SDP-IV , SS , LG3.1","FA , ND , LG3.1", "SWE , BiB , LG3.1","COA , TS , LG3.1","C1-OOPs Lab ; C2- COA Lab , C1-ADB,Ganga Madam, ADP ; C2-SMU,DGR, SOB, C1-Zone 3 and Zone 4 ; C2- L.G-4.1","C1-OOPs Lab ; C2- COA Lab , C1-ADB,Ganga Madam, ADP ; C2-SMU,DGR, SOB, C1-Zone 3 and Zone 4 ; C2- L.G-4.1","C1-OOPs Lab ; C2- COA Lab , C1-ADB,Ganga Madam, ADP ; C2-SMU,DGR, SOB, C1-Zone 3 and Zone 4 ; C2- L.G-4.1","Remedial Class"},//Tuesday
                            {"COA , SMU , LG3.1","FA , RKB , LG3.1", "DAA , APM , LG3.1","CC-IV , RS , Annex 5.1","C1-SWE Lab ; C2- DAA Lab , C1-SHR,DRS, SAS ; C2-APM,RUD, ASE , C1- Zone 3 and Zone 4 ; C2-Zone 1 and Zone 2","C1-SWE Lab ; C2- DAA Lab , C1-SHR,DRS, SAS ; C2-APM,RUD, ASE , C1- Zone 3 and Zone 4 ; C2-Zone 1 and Zone 2","C1-SWE Lab ; C2- DAA Lab , C1-SHR,DRS, SAS ; C2-APM,RUD, ASE , C1- Zone 3 and Zone 4 ; C2-Zone 1 and Zone 2","Mentoring"},//Wednesday
                            {"OOPs , Ganga Madam , LG3.1","C1-DAA Lab ; C2- SWE Lab , C1-AP,RUD ; C2-RS,AR , C1- Zone 3 and Zone 4 ; C2-Zone 1 and Zone 2", "C1-DAA Lab ; C2- SWE Lab , C1-AP,RUD ; C2-RS,AR , C1- Zone 3 and Zone 4 ; C2-Zone 1 and Zone 2","C1-DAA Lab ; C2- SWE Lab , C1-AP,RUD ; C2-RS,AR , C1- Zone 3 and Zone 4 ; C2-Zone 1 and Zone 2","Placement , Gurukul Science Auditorium","Placement , Gurukul Science Auditorium","DM , AG , LG3.1","Mentoring"},//Thursday
                            {"DM , BB , LG3.1","DM , KB , LG3.1", "DAA , AS , LG3.1","SWE , RS , LG3.1","SWE , BIB , LG3.1","OOPs , AYC , LG3.1","DAA , PLS , LG3.1","Project"},//Friday
                    },//For CSE A
                    {
                            {"COA, TS, LG3.2","EVS , VP , LG3.2", "ESP-IV , CHM , LG3.2","SWE , BIB , LG3.2","C3-SWE Lab ; C4- DAA Lab , C3-BiB,RS,SAS ; C4-PLS,AS,ASE , C3-Zone 1 and Zone 2 ; C4- Annex-2.1","C3-SWE Lab ; C4- DAA Lab , C3-BiB,RS,SAS ; C4-PLS,AS,ASE , C3-Zone 1 and Zone 2 ; C4- Annex-2.1","C3-SWE Lab ; C4- DAA Lab , C3-BiB,RS,SAS ; C4-PLS,AS,ASE , C3-Zone 1 and Zone 2 ; C4- Annex-2.1","Mentoring "},//Monday
                            {"C3- DAA Lab ; C4- SWE Lab , C3-PLS,AP,ASE ; C4-DRS,SHR,SAS , C3-Zone 1 and Zone 2 ; C4-Zone 3 and Zone 4 ","C3- DAA Lab ; C4- SWE Lab , C3-PLS,AP,ASE ; C4-DRS,SHR,SAS , C3-Zone 1 and Zone 2 ; C4-Zone 3 and Zone 4 ", "C3- DAA Lab ; C4- SWE Lab , C3-PLS,AP,ASE ; C4-DRS,SHR,SAS , C3-Zone 1 and Zone 2 ; C4-Zone 3 and Zone 4 ","SDP-IV , SS , LG3.2","COA , SMU , LG3.2","DM , KB , LG3.2","DAA , PLS , LG3.2","Innovative Project"},//Tuesday
                            {"FA  , ND , LG3.2","COA , SHM , LG3.2", "SWE  , DRS , LG3.2","DAA  , APM , LG3.2","CC-IV  , RS , Annex 5.1","DM  , AG , LG3.2","DM , ATC , LG3.2","Remedial Class"},//Wednesday
                            {"C3-OOPs Lab ; C4- COA Lab , C3-AMU,AM ; C4-TS,AR , C3- Annex 3.1 ; C4- LG 4.1","C3-OOPs Lab ; C4- COA Lab , C3-AMU,AM ; C4-TS,AR , C3- Annex 3.1 ; C4- LG 4.1", "C3-OOPs Lab ; C4- COA Lab , C3-AMU,AM ; C4-TS,AR , C3- Annex 3.1 ; C4- LG 4.1","FA  , RKB , LG3.2","Placement  , Gurukul Science Auditorium","Placement  , Gurukul Science Auditorium","SWE ,  RS , LG3.2","Mentoring"},//Thursday
                            {"OOPs ,  ADB , LG3.2","OOPs ,  AYC , LG3.2", "OOPs  , Ganga Madam , LG3.2","DAA , AS , LG3.2","C3-COA Lab ; C4- OOPs Lab , C3-SHM,AR ; C4-AMU,AG , C3- LG 4.1 ; C4- Annex 3.1","C3-COA Lab ; C4- OOPs Lab , C3-SHM,AR ; C4-AMU,AG , C3- LG 4.1 ; C4- Annex 3.1","C3-COA Lab ; C4- OOPs Lab , C3-SHM,AR ; C4-AMU,AG , C3- LG 4.1 ; C4- Annex 3.1","Project"},//Friday
                    },//For CSE B
                    {
                            {"C5-OOPs Lab ; C6- DAA Lab , C5-Ganga Madam,ADB,ANM ; C6-RUD,AS,ASE , C5- Zone-1 and Zone-2 ; C6- Zone-3 and Zone-4","C5-OOPs Lab ; C6- DAA Lab , C5-Ganga Madam,ADB,ANM ; C6-RUD,AS,ASE , C5- Zone-1 and Zone-2 ; C6- Zone-3 and Zone-4", "C5-OOPs Lab ; C6- DAA Lab , C5-Ganga Madam,ADB,ANM ; C6-RUD,AS,ASE , C5- Zone-1 and Zone-2 ; C6- Zone-3 and Zone-4","COA  , SHM , LG3.3","SWE  ,  DRS , LG3.3","EVS  ,  VP , LG3.3","ESP-IV  , CHM , LG3.3","Innovative Project , LG3.3"},//Monday
                            {"DAA , APM , LG3.3","SWE , DRS , LG3.3", "SWE , RS  , LG3.3","FA , RKB , LG3.3","SDP-IV , SS , LG3.3","COA , SMU , LG3.3","OOPs  , AYC , LG3.3","Mentoring"},//Tuesday
                            {"C5-DAA Lab ; C6- COA Lab , C5-APM,CHM,ASE ; C6-SMU,SHM,SOB , C5- Zone 3 and Zone 4 ; C6-Zone 1 and Zone 2","C5-DAA Lab ; C6- COA Lab , C5-APM,CHM,ASE ; C6-SMU,SHM,SOB , C5- Zone 3 and Zone 4 ; C6-Zone 1 and Zone 2", "C5-DAA Lab ; C6- COA Lab , C5-APM,CHM,ASE ; C6-SMU,SHM,SOB , C5- Zone 3 and Zone 4 ; C6-Zone 1 and Zone 2","COA  , SHM , LG3.3","OOPs  , ADB , LG3.3","CC-IV  , RS , Annex 5.1","FA , ND , LG3.3","Remedial Class   "},//Wednesday
                            {"DAA , PLS , LG3.3","C5-SWE Lab ; C6- OOPs Lab , C5-ND,AR ; C6-Ganga Madam,AG ,  C5- LG 4.1 ; C6- Annex 2.1", "C5-SWE Lab ; C6- OOPs Lab , C5-ND,AR ; C6-Ganga Madam,AG ,  C5- LG 4.1 ; C6- Annex 2.1","C5-SWE Lab ; C6- OOPs Lab , C5-ND,AR ; C6-Ganga Madam,AG ,  C5- LG 4.1 ; C6- Annex 2.1","Placement , Gurukul Science Auditorium","Placement , Gurukul Science Auditorium","DM , ATC , LG3.3","Mentoring"},//Thursday
                            {"C5- COA Lab ; C6- SWE Lab , C5-ML,SJ ; C6-ND,BiB , C5- LG 4.1 ; C6- Zone 3 and Zone 4","C5- COA Lab ; C6- SWE Lab , C5-ML,SJ ; C6-ND,BiB , C5- LG 4.1 ; C6- Zone 3 and Zone 4", "C5- COA Lab ; C6- SWE Lab , C5-ML,SJ ; C6-ND,BiB , C5- LG 4.1 ; C6- Zone 3 and Zone 4","DM , AG , LG3.3","DAA , AS , LG3.3","OOPs , Ganga Madam , LG3.3","DM , KB , LG3.3","Project"},//Friday
                    },//For CSE C
            },//2nd Year
            {
                    {
                            {"SDP-VI  , RD , LG4.2","Compiler  , BB , LG4.2", "Cloud Computing  , AYC , LG4.2","Compiler  , AP , LG4.2","Cloud Computing  , VP , LG4.2","PE-III (NLP)  , MD , LG4.2","CN , NC , LG4.2","Mentoring"},//Monday
                            {"Placement , Gurukul Science Auditorium","Placement , Gurukul Science Auditorium", "PE-II (Cyber Security/Soft Computing) , ML/SKM , LG4.2/LG4.1","CN , RUD , Annex 4.11","C1-Compiler Lab ; C2-Compiler Lab , C1-SHM,BG,SHD ; C2-KB, ML,UG , C1-Annex-3.1; C2-Zone 1 & Zone 2","C1-Compiler Lab ; C2-Compiler Lab , C1-SHM,BG,SHD ; C2-KB, ML,UG , C1-Annex-3.1; C2-Zone 1 & Zone 2","C1-Compiler Lab ; C2-Compiler Lab , C1-SHM,BG,SHD ; C2-KB, ML,UG , C1-Annex-3.1; C2-Zone 1 & Zone 2","Project"},//Tuesday
                            {"CN , SKM , LG4.2","C1-Cloud Computing Lab ; C2-CN Lab , C1-VP,SB,ADP ; C2-ML,AM,ANM  , C1-Zone-1.2 ; C2- Annex -2.1", "C1-Cloud Computing Lab ; C2-CN Lab , C1-VP,SB,ADP ; C2-ML,AM,ANM  , C1-Zone-1.2 ; C2- Annex -2.1","C1-Cloud Computing Lab ; C2-CN Lab , C1-VP,SB,ADP ; C2-ML,AM,ANM  , C1-Zone-1.2 ; C2- Annex -2.1","Cloud Computing , VP , LG4.2","Cloud Computing , SA  , LG4.2","OE-I (Multimedia Tools and Applications/Project Management) , SGH/RD , LG4.2/LG4.3","Mentoring"},//Wednesday
                            {"CN , SKM , LG4.2","CC-VI  , TS ,  Central Lab", "ESP-VI , BB , LG4.2","OE-I (Multimedia Tools and Applications/Project Management) , NC/SB , LG4.2/LG4.3","C1-CN Lab ; C2-Cloud Computing Lab , C1-RKB,AM ; C2-SB,VP , C1-Annex -2.1 ; C2- Annex-5.1","C1-CN Lab ; C2-Cloud Computing Lab , C1-RKB,AM ; C2-SB,VP , C1-Annex -2.1 ; C2- Annex-5.1","C1-CN Lab ; C2-Cloud Computing Lab , C1-RKB,AM ; C2-SB,VP , C1-Annex -2.1 ; C2- Annex-5.1","Project"},//Thursday
                            {"Placement , Gurukul Science Auditorium","Placement , Gurukul Science Auditorium", "Compiler , KB , LG4.2","PE-II (Cyber Security/Soft Computing) , RD/BiB , LG4.2/LG4.3","Compiler  , BB , LG4.2","PE-III (NLP)  , SDS , LG4.2","CC-VI , RS , Central Lab","Remedial Class"},//Friday
                    },//For CSE A
                    {
                            {"Cloud Computing  , AYC , LG4.3","Compiler  , AP , LG4.3", "ESP-VI  , BB ,  LG4.3","PE-III (NLP) , SDS , LG4.3","C3-Compiler Lab ; C4- Cloud Computing Lab , C3-AMU,BB,SHD ; C4-SRM,SA,UG , C3-Annex-5.1 ; C4- Annex -3.1 ","C3-Compiler Lab ; C4- Cloud Computing Lab , C3-AMU,BB,SHD ; C4-SRM,SA,UG , C3-Annex-5.1 ; C4- Annex -3.1 ","C3-Compiler Lab ; C4- Cloud Computing Lab , C3-AMU,BB,SHD ; C4-SRM,SA,UG , C3-Annex-5.1 ; C4- Annex -3.1 ","Mentoring"},//Monday
                            {"Placement , Gurukul Science Auditorium ","Placement , Gurukul Science Auditorium ", "PE-II (Cyber Security/Soft Computing) , ML/SKM ,  LG4.2/LG4.1","CN , RUD , LG4.3","C3-Cloud Computing Lab; C4-CN Lab , C3-SRM,SA,SAS ; C4-SKM,NC,ANM , C3-Annex -2.1 ; C4- Annex-5.1","C3-Cloud Computing Lab; C4-CN Lab , C3-SRM,SA,SAS ; C4-SKM,NC,ANM , C3-Annex -2.1 ; C4- Annex-5.1","C3-Cloud Computing Lab; C4-CN Lab , C3-SRM,SA,SAS ; C4-SKM,NC,ANM , C3-Annex -2.1 ; C4- Annex-5.1","Project"},//Tuesday
                            {"C3-CN Lab ; C4-Compiler Lab , C3-NC,SKM, UG ; C4-KB,BG, SHD , SGH/RD , C3-Annex -2.1 ; C4- Annex-5.1","C3-CN Lab ; C4-Compiler Lab , C3-NC,SKM, UG ; C4-KB,BG, SHD , SGH/RD , C3-Annex -2.1 ; C4- Annex-5.1", "C3-CN Lab ; C4-Compiler Lab , C3-NC,SKM, UG ; C4-KB,BG, SHD , SGH/RD , C3-Annex -2.1 ; C4- Annex-5.1","PE-III (NLP) , MD , LG4.3","SDP-VI  , RD , LG4.3","Compiler , KB , LG4.3","OE-I (Multimedia Tools and Applications/Project Management) , LG4.2/LG4.3","Project"},//Wednesday
                            {"CC-VI  , TS , Central Lab","CN  , AS , LG4.3", "CN , SKM , LG4.3","OE-I (Multimedia Tools and Applications/Project Management) , NC/SB , LG4.2/LG4.3","CN  ,AS  , LG4.3","Compiler Cloud  , DGR ,  LG4.3","Computing , SB , LG4.3","Project"},//Thursday
                            {"Placement  , Gurukul Science Auditorium ","Placement  , Gurukul Science Auditorium ", "Cloud Computing , AYC , LG4.3","PE-II (Cyber Security/Soft Computing) , RD/BiB , LG4.2/LG4.3","CC-VI  , RS , Central Lab","Compiler  , KB , LG4.3","Compiler , AP , LG4.3","Remedial Class"},//Friday
                    },//For CSE B
                    {
                            {"Compiler  , BB , LG4.4 ","CC-VI  , TS , LG4.4", "Cloud Computing  , SA , LG4.4","Cloud Computing  , SB , LG4.4","CN  , RUD , LG4.4","CN  , NC , LG4.4","Cloud Computing , VP , LG4.4","Mentoring"},//Monday
                            {"Placement , Gurukul Science Auditorium","Placement , Gurukul Science Auditorium", "PE-II (Cyber Security/Soft Computing) , MBS/SKM , LG4.4/LG4.1","PE-III (NLP)  ,  MD ,  Annex 4.11","Cloud Computing  , SA , LG4.4","Compiler  , DGR , LG4.4","ESP-VI  , BB , LG4.4","Project"},//Tuesday
                            {"C5-Compiler Lab; C6-CN Lab , C5-AMU,SHM,SAS ; C6-RKB,CHM , C5-Annex-3.1 ; C6-Zone-1 and Zone-2","C5-Compiler Lab; C6-CN Lab , C5-AMU,SHM,SAS ; C6-RKB,CHM , C5-Annex-3.1 ; C6-Zone-1 and Zone-2", "C5-Compiler Lab; C6-CN Lab , C5-AMU,SHM,SAS ; C6-RKB,CHM , C5-Annex-3.1 ; C6-Zone-1 and Zone-2","PE-III (NLP)  , SDS , LG4.4","Cloud Computing  , SB , LG4.4","Compiler , DGR , LG4.4","OE-I (Multimedia Tools and Applications/Project Management) , SGH/RD , LG4.2/LG4.3","Project"},//Wednesday
                            {"C5-Cloud Computing Lab ; C6-Compiler Lab , C5-AM,SJ ; C6-BB,ML , C5-Annex -2.1 ; C6- Annex-5.1","C5-Cloud Computing Lab ; C6-Compiler Lab , C5-AM,SJ ; C6-BB,ML , C5-Annex -2.1 ; C6- Annex-5.1", "C5-Cloud Computing Lab ; C6-Compiler Lab , C5-AM,SJ ; C6-BB,ML , C5-Annex -2.1 ; C6- Annex-5.1","OE-I (Multimedia Tools and Applications/Project Management) , NC/SB , LG4.2/LG4.3","SDP-VI  , RD , Central lab Zone 1 and Zone 2","CN  , AS , LG4.4","CN , NC , LG4.4","Project"},//Thursday
                            {"Placement , Gurukul Science Auditorium","Placement , Gurukul Science Auditorium", "CC-VI , RS , Central Lab","PE-II (Cyber Security/Soft Computing) , RD/BiB , LG4.2/LG4.3","C5-CN Lab ; C6-Cloud Computing Lab , C5-DGR,CHM ; C6-AM,SJ , C5-Annex -5.1 ; C6- Annex-2.1","C5-CN Lab ; C6-Cloud Computing Lab , C5-DGR,CHM ; C6-AM,SJ , C5-Annex -5.1 ; C6- Annex-2.1","C5-CN Lab ; C6-Cloud Computing Lab , C5-DGR,CHM ; C6-AM,SJ , C5-Annex -5.1 ; C6- Annex-2.1","Remedial Class"},//Friday
                    },//For CSE C
            },//3rd Year
            {
                    {
                            {"Project","Project", "Project","Project","Project","Project","Project","Mentoring"},//Monday
                            {"ESP VIII , AG , LG 3.4","Project", "Project","Project","Data Analytics and Visualization/Data Encryption and Compression Project Project , ND/AS , Annex 4.11/LG 4.7","Project","Project","Mentoring"},//Tuesday
                            {"Project", "Project" , "Project" , "History of Science and Engineering , VP , LG 3.4" , "Project" , "SDP-VIII , CHM , LG 3.4" , "Project" , "Remedial Class"},//Wednesday
                            {"Project", "Cyber Law and IPR , SGH , LG 3.4" , "Data Analytics and Visualization/Data Encryption and Compression , ADB/DGR , Annex 4.11/LG 4.7" , "Project" , "Project" , "Data Analytics and Visualization/Data Encryption and Compression , AMU/SS , Annex 4.11/LG 4.7" , "Project" , "Mentoring"},//Thursday
                            {"Project", "Project" , "Project" , "Project" , "Project" , "Project" , "Project" , "Remedial Class"},//Friday
                    },//For CSE A
                    {
                            {"Project","Project", "Project","Project","Project","Project","Project","Mentoring"},//Monday
                            {"ESP VIII , AG , LG 4.7","Project", "Project","Project","Data Analytics and Visualization/Data Encryption and Compression Project Project , ND/AS , Annex 4.11/LG 4.7","Project","Project","Mentoring"},//Tuesday
                            {"Cyber Law and IPR , SGH , LG 4.7", "Project" , "Project" , "Project" , "Project" , "SDP-VIII , CHM , LG 4.7" , "Project" , "Remedial Class"},//Wednesday
                            {"Project", "Project" , "Data Analytics and Visualization/Data Encryption and Compression , ADB/DGR , Annex 4.11/LG 4.7" , "Project" , "History of Science and Engineering , VP , LG 4.7" , "Data Analytics and Visualization/Data Encryption and Compression , AMU/SS , Annex 4.11/LG 4.7" , "Project" , "Mentoring"},//Thursday
                            {"Project", "Project" , "Project" , "Project" , "Project" , "Project" , "Project" , "Remedial Class"},//Friday
                    },//For CSE B
                    {
                            {"Project","Project", "Project","Project","Project","Project","Project","Mentoring"},//Monday
                            {"ESP VIII , AG , LG 4.6","Project", "Project","Project","Data Analytics and Visualization/Data Encryption and Compression Project Project , ND/AS , Annex 4.11/LG 4.7","Project","Project","Mentoring"},//Tuesday
                            {"Project", "Project" , "History of Science and Engineering , VP , LG 4.6" , "Project" , "Project" , "SDP-VIII , CHM , LG 4.6" , "Project" , "Remedial Class"},//Wednesday
                            {"Project", "Project" , "Data Analytics and Visualization/Data Encryption and Compression , ADB/DGR , Annex 4.11/LG 4.7" , "Cyber Law and IPR , SGH , LG 4.6" , "Project" , "Data Analytics and Visualization/Data Encryption and Compression , AMU/SS , Annex 4.11/LG 4.7" , "Project" , "Mentoring"},//Thursday
                            {"Project", "Project" , "Project" , "Project" , "Project" , "Project" , "Project" , "Remedial Class"},//Friday
                    },//For CSE C
            }//4th Year

    };
    private String Day,YR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        button5=findViewById(R.id.button5);
        button6=findViewById(R.id.button6);
        button7=findViewById(R.id.button7);
        button8=findViewById(R.id.button8);
        radioButton1=findViewById(R.id.radioButton1);
        radioButton2=findViewById(R.id.radioButton2);
        textView=findViewById(R.id.textViewResult);
        spinner=findViewById(R.id.spinner);
        spinnerB=findViewById(R.id.spinnerB);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this, R.layout.spinner_new,days);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Day=adapterView.getItemAtPosition(i).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });


        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(MainActivity.this, R.layout.spinner_new,yr);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerB.setAdapter(adapter1);

        spinnerB.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                YR=adapterView.getItemAtPosition(i).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });


        Toast.makeText(MainActivity.this, "Select Your Year,Your Section,Day and Time", Toast.LENGTH_LONG).show();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnimation();

                switch (YR){
                    case "2nd year":
                        if(radioButton1.isChecked()) {
                            switch (Day){
                                case "Monday":
                                    textView.setText(TimeTable[0][0][0][0]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[0][0][1][0]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[0][0][2][0]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[0][0][3][0]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[0][0][4][0]);
                                    break;
                            }
                        } else if (radioButton2.isChecked()) {
                            switch (Day){
                                case "Monday":
                                    textView.setText(TimeTable[0][1][0][0]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[0][1][1][0]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[0][1][2][0]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[0][1][3][0]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[0][1][4][0]);
                                    break;
                            }
                        }
                        else {
                            switch (Day){
                                case "Monday":
                                    textView.setText(TimeTable[0][2][0][0]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[0][2][1][0]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[0][2][2][0]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[0][2][3][0]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[0][2][4][0]);
                                    break;
                            }
                        }
                        break;
                    case "3rd year":
                        if(radioButton1.isChecked()) {
                            switch (Day){
                                case "Monday":
                                    textView.setText(TimeTable[1][0][0][0]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[1][0][1][0]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[1][0][2][0]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[1][0][3][0]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[1][0][4][0]);
                                    break;
                            }
                        } else if (radioButton2.isChecked()) {
                            switch (Day){
                                case "Monday":
                                    textView.setText(TimeTable[1][1][0][0]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[1][1][1][0]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[1][1][2][0]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[1][1][3][0]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[1][1][4][0]);
                                    break;
                            }
                        }
                        else {
                            switch (Day){
                                case "Monday":
                                    textView.setText(TimeTable[1][2][0][0]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[1][2][1][0]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[1][2][2][0]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[1][2][3][0]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[1][2][4][0]);
                                    break;
                            }
                        }
                        break;
                    case "4th year":
                        if(radioButton1.isChecked()) {
                            switch (Day){
                                case "Monday":
                                    textView.setText(TimeTable[2][0][0][0]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[2][0][1][0]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[2][0][2][0]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[2][0][3][0]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[2][0][4][0]);
                                    break;
                            }
                        } else if (radioButton2.isChecked()) {
                            switch (Day){
                                case "Monday":
                                    textView.setText(TimeTable[2][1][0][0]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[2][1][1][0]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[2][1][2][0]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[2][1][3][0]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[2][1][4][0]);
                                    break;
                            }
                        }
                        else {
                            switch (Day){
                                case "Monday":
                                    textView.setText(TimeTable[2][2][0][0]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[2][2][1][0]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[2][2][2][0]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[2][2][3][0]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[2][2][4][0]);
                                    break;
                            }
                        }
                        break;
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnimation();
                switch (YR){
                    case "2nd year":
                        if(radioButton1.isChecked()) {
                            switch (Day){
                                case "Monday":
                                    textView.setText(TimeTable[0][0][0][1]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[0][0][1][1]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[0][0][2][1]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[0][0][3][1]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[0][0][4][1]);
                                    break;
                            }
                        } else if (radioButton2.isChecked()) {
                            switch (Day){
                                case "Monday":
                                    textView.setText(TimeTable[0][1][0][1]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[0][1][1][1]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[0][1][2][1]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[0][1][3][1]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[0][1][4][1]);
                                    break;
                            }
                        }
                        else {
                            switch (Day){
                                case "Monday":
                                    textView.setText(TimeTable[0][2][0][1]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[0][2][1][1]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[0][2][2][1]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[0][2][3][1]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[0][2][4][1]);
                                    break;
                            }
                        }
                        break;
                    case "3rd year":
                        if(radioButton1.isChecked()) {
                            switch (Day){
                                case "Monday":
                                    textView.setText(TimeTable[1][0][0][1]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[1][0][1][1]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[1][0][2][1]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[1][0][3][1]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[1][0][4][1]);
                                    break;
                            }
                        } else if (radioButton2.isChecked()) {
                            switch (Day){
                                case "Monday":
                                    textView.setText(TimeTable[1][1][0][1]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[1][1][1][1]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[1][1][2][1]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[1][1][3][1]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[1][1][4][1]);
                                    break;
                            }
                        }
                        else {
                            switch (Day){
                                case "Monday":
                                    textView.setText(TimeTable[1][2][0][1]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[1][2][1][1]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[1][2][2][1]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[1][2][3][1]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[1][2][4][1]);
                                    break;
                            }
                        }
                        break;
                    case "4th year":
                        if(radioButton1.isChecked()) {
                            switch (Day){
                                case "Monday":
                                    textView.setText(TimeTable[2][0][0][1]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[2][0][1][1]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[2][0][2][1]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[2][0][3][1]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[2][0][4][1]);
                                    break;
                            }
                        } else if (radioButton2.isChecked()) {
                            switch (Day){
                                case "Monday":
                                    textView.setText(TimeTable[2][1][0][1]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[2][1][1][1]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[2][1][2][1]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[2][1][3][1]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[2][1][4][1]);
                                    break;
                            }
                        }
                        else {
                            switch (Day){
                                case "Monday":
                                    textView.setText(TimeTable[2][2][0][1]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[2][2][1][1]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[2][2][2][1]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[2][2][3][1]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[2][2][4][1]);
                                    break;
                            }
                        }
                        break;
                }

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnimation();

                switch (YR) {
                    case "2nd year":
                        if (radioButton1.isChecked()) {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[0][0][0][2]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[0][0][1][2]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[0][0][2][2]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[0][0][3][2]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[0][0][4][2]);
                                    break;
                            }
                        } else if (radioButton2.isChecked()) {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[0][1][0][2]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[0][1][1][2]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[0][1][2][2]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[0][1][3][2]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[0][1][4][2]);
                                    break;
                            }
                        } else {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[0][2][0][2]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[0][2][1][2]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[0][2][2][2]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[0][2][3][2]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[0][2][4][2]);
                                    break;
                            }
                        }
                        break;
                    case "3rd year":
                        if (radioButton1.isChecked()) {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[1][0][0][2]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[1][0][1][2]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[1][0][2][2]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[1][0][3][2]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[1][0][4][2]);
                                    break;
                            }
                        } else if (radioButton2.isChecked()) {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[1][1][0][2]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[1][1][1][2]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[1][1][2][2]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[1][1][3][2]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[1][1][4][2]);
                                    break;
                            }
                        } else {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[1][2][0][2]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[1][2][1][2]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[1][2][2][2]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[1][2][3][2]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[1][2][4][2]);
                                    break;
                            }
                        }
                        break;
                    case "4th year":
                        if (radioButton1.isChecked()) {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[2][0][0][2]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[2][0][1][2]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[2][0][2][2]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[2][0][3][2]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[2][0][4][2]);
                                    break;
                            }
                        } else if (radioButton2.isChecked()) {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[2][1][0][2]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[2][1][1][2]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[2][1][2][2]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[2][1][3][2]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[2][1][4][2]);
                                    break;
                            }
                        } else {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[2][2][0][2]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[2][2][1][2]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[2][2][2][2]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[2][2][3][2]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[2][2][4][2]);
                                    break;
                            }
                        }
                        break;
                }
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnimation();

                switch (YR) {
                    case "2nd year":
                        if (radioButton1.isChecked()) {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[0][0][0][3]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[0][0][1][3]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[0][0][2][3]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[0][0][3][3]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[0][0][4][3]);
                                    break;
                            }
                        } else if (radioButton2.isChecked()) {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[0][1][0][3]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[0][1][1][3]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[0][1][2][3]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[0][1][3][3]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[0][1][4][3]);
                                    break;
                            }
                        } else {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[0][2][0][3]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[0][2][1][3]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[0][2][2][3]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[0][2][3][3]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[0][2][4][3]);
                                    break;
                            }
                        }
                        break;
                    case "3rd year":
                        if (radioButton1.isChecked()) {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[1][0][0][3]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[1][0][1][3]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[1][0][2][3]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[1][0][3][3]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[1][0][4][3]);
                                    break;
                            }
                        } else if (radioButton2.isChecked()) {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[1][1][0][3]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[1][1][1][3]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[1][1][2][3]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[1][1][3][3]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[1][1][4][3]);
                                    break;
                            }
                        } else {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[1][2][0][3]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[1][2][1][3]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[1][2][2][3]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[1][2][3][3]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[1][2][4][3]);
                                    break;
                            }
                        }
                        break;
                    case "4th year":
                        if (radioButton1.isChecked()) {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[2][0][0][3]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[2][0][1][3]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[2][0][2][3]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[2][0][3][3]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[2][0][4][3]);
                                    break;
                            }
                        } else if (radioButton2.isChecked()) {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[2][1][0][3]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[2][1][1][3]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[2][1][2][3]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[2][1][3][3]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[2][1][4][3]);
                                    break;
                            }
                        } else {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[2][2][0][3]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[2][2][1][3]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[2][2][2][3]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[2][2][3][3]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[2][2][4][3]);
                                    break;
                            }
                        }
                        break;
                }
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnimation();

                switch (YR) {
                    case "2nd year":
                        if (radioButton1.isChecked()) {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[0][0][0][4]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[0][0][1][4]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[0][0][2][4]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[0][0][3][4]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[0][0][4][4]);
                                    break;
                            }
                        } else if (radioButton2.isChecked()) {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[0][1][0][4]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[0][1][1][4]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[0][1][2][4]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[0][1][3][4]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[0][1][4][4]);
                                    break;
                            }
                        } else {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[0][2][0][4]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[0][2][1][4]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[0][2][2][4]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[0][2][3][4]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[0][2][4][4]);
                                    break;
                            }
                        }
                        break;
                    case "3rd year":
                        if (radioButton1.isChecked()) {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[1][0][0][4]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[1][0][1][4]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[1][0][2][4]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[1][0][3][4]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[1][0][4][4]);
                                    break;
                            }
                        } else if (radioButton2.isChecked()) {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[1][1][0][4]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[1][1][1][4]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[1][1][2][4]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[1][1][3][4]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[1][1][4][4]);
                                    break;
                            }
                        } else {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[1][2][0][4]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[1][2][1][4]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[1][2][2][4]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[1][2][3][4]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[1][2][4][4]);
                                    break;
                            }
                        }
                        break;
                    case "4th year":
                        if (radioButton1.isChecked()) {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[2][0][0][4]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[2][0][1][4]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[2][0][2][4]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[2][0][3][4]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[2][0][4][4]);
                                    break;
                            }
                        } else if (radioButton2.isChecked()) {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[2][1][0][4]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[2][1][1][4]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[2][1][2][4]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[2][1][3][4]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[2][1][4][4]);
                                    break;
                            }
                        } else {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[2][2][0][4]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[2][2][1][4]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[2][2][2][4]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[2][2][3][4]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[2][2][4][4]);
                                    break;
                            }
                        }
                        break;
                }
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                startAnimation();

                switch (YR) {
                    case "2nd year":
                        if (radioButton1.isChecked()) {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[0][0][0][5]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[0][0][1][5]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[0][0][2][5]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[0][0][3][5]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[0][0][4][5]);
                                    break;
                            }
                        } else if (radioButton2.isChecked()) {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[0][1][0][5]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[0][1][1][5]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[0][1][2][5]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[0][1][3][5]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[0][1][4][5]);
                                    break;
                            }
                        } else {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[0][2][0][5]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[0][2][1][5]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[0][2][2][5]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[0][2][3][5]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[0][2][4][5]);
                                    break;
                            }
                        }
                        break;
                    case "3rd year":
                        if (radioButton1.isChecked()) {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[1][0][0][5]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[1][0][1][5]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[1][0][2][5]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[1][0][3][5]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[1][0][4][5]);
                                    break;
                            }
                        } else if (radioButton2.isChecked()) {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[1][1][0][5]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[1][1][1][5]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[1][1][2][5]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[1][1][3][5]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[1][1][4][5]);
                                    break;
                            }
                        } else {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[1][2][0][5]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[1][2][1][5]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[1][2][2][5]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[1][2][3][5]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[1][2][4][5]);
                                    break;
                            }
                        }
                        break;
                    case "4th year":
                        if (radioButton1.isChecked()) {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[2][0][0][5]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[2][0][1][5]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[2][0][2][5]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[2][0][3][5]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[2][0][4][5]);
                                    break;
                            }
                        } else if (radioButton2.isChecked()) {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[2][1][0][5]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[2][1][1][5]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[2][1][2][5]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[2][1][3][5]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[2][1][4][5]);
                                    break;
                            }
                        }
                        else{
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[2][2][0][5]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[2][2][1][5]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[2][2][2][5]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[2][2][3][5]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[2][2][4][5]);
                                    break;
                            }
                        }
                }
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnimation();

                switch (YR) {
                    case "2nd year":
                        if (radioButton1.isChecked()) {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[0][0][0][6]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[0][0][1][6]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[0][0][2][6]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[0][0][3][6]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[0][0][4][6]);
                                    break;
                            }
                        } else if (radioButton2.isChecked()) {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[0][1][0][6]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[0][1][1][6]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[0][1][2][6]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[0][1][3][6]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[0][1][4][6]);
                                    break;
                            }
                        } else {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[0][2][0][6]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[0][2][1][6]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[0][2][2][6]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[0][2][3][6]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[0][2][4][6]);
                                    break;
                            }
                        }
                        break;
                    case "3rd year":
                        if (radioButton1.isChecked()) {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[1][0][0][6]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[1][0][1][6]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[1][0][2][6]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[1][0][3][6]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[1][0][4][6]);
                                    break;
                            }
                        } else if (radioButton2.isChecked()) {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[1][1][0][6]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[1][1][1][6]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[1][1][2][6]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[1][1][3][6]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[1][1][4][6]);
                                    break;
                            }
                        } else {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[1][2][0][6]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[1][2][1][6]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[1][2][2][6]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[1][2][3][6]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[1][2][4][6]);
                                    break;
                            }
                        }
                        break;
                    case "4th year":
                        if (radioButton1.isChecked()) {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[2][0][0][6]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[2][0][1][6]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[2][0][2][6]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[2][0][3][6]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[2][0][4][6]);
                                    break;
                            }
                        } else if (radioButton2.isChecked()) {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[2][1][0][6]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[2][1][1][6]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[2][1][2][6]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[2][1][3][6]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[2][1][4][6]);
                                    break;
                            }
                        } else {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[2][2][0][6]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[2][2][1][6]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[2][2][2][6]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[2][2][3][6]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[2][2][4][6]);
                                    break;
                            }
                        }
                        break;
                }
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAnimation();

                switch (YR) {
                    case "2nd year":
                        if (radioButton1.isChecked()) {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[0][0][0][7]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[0][0][1][7]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[0][0][2][7]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[0][0][3][7]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[0][0][4][7]);
                                    break;
                            }
                        } else if (radioButton2.isChecked()) {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[0][1][0][7]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[0][1][1][7]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[0][1][2][7]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[0][1][3][7]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[0][1][4][7]);
                                    break;
                            }
                        } else {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[0][2][0][7]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[0][2][1][7]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[0][2][2][7]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[0][2][3][7]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[0][2][4][7]);
                                    break;
                            }
                        }
                        break;
                    case "3rd year":
                        if (radioButton1.isChecked()) {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[1][0][0][7]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[1][0][1][7]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[1][0][2][7]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[1][0][3][7]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[1][0][4][7]);
                                    break;
                            }
                        } else if (radioButton2.isChecked()) {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[1][1][0][7]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[1][1][1][7]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[1][1][2][7]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[1][1][3][7]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[1][1][4][7]);
                                    break;
                            }
                        } else {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[1][2][0][7]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[1][2][1][7]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[1][2][2][7]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[1][2][3][7]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[1][2][4][7]);
                                    break;
                            }
                        }
                        break;
                    case "4th year":
                        if (radioButton1.isChecked()) {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[2][0][0][7]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[2][0][1][7]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[2][0][2][7]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[2][0][3][7]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[2][0][4][7]);
                                    break;
                            }
                        } else if (radioButton2.isChecked()) {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[2][1][0][7]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[2][1][1][7]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[2][1][2][7]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[2][1][3][7]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[2][1][4][7]);
                                    break;
                            }
                        } else {
                            switch (Day) {
                                case "Monday":
                                    textView.setText(TimeTable[2][2][0][7]);
                                    break;
                                case "Tuesday":
                                    textView.setText(TimeTable[2][2][1][7]);
                                    break;
                                case "Wednesday":
                                    textView.setText(TimeTable[2][2][2][7]);
                                    break;
                                case "Thursday":
                                    textView.setText(TimeTable[2][2][3][7]);
                                    break;
                                case "Friday":
                                    textView.setText(TimeTable[2][2][4][7]);
                                    break;
                            }
                        }
                        break;
                }
            }
        });

    }

    private void startAnimation()
    {
        Animation animation= AnimationUtils.loadAnimation(this, R.anim.anim);
        textView.startAnimation(animation);
    }
}
