package com.example.myapplication;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;


public class first_page  extends AppCompatActivity {
                                private EditText mKeyEditText;
                                private Button mPlayButton;

                                private FirebaseRemoteConfig mFirebaseRemoteConfig;

                                @Override
                                protected void onCreate(Bundle savedInstanceState) {
                                    super.onCreate(savedInstanceState);
                                    setContentView(R.layout.activity_first_page);

                                    mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();

                                    FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                                            .setMinimumFetchIntervalInSeconds(3600)
                                            .build();
                                    mFirebaseRemoteConfig.setConfigSettingsAsync(configSettings);
                                    mFirebaseRemoteConfig.setDefaultsAsync(R.xml.remote_config_defaults);

                                    mFirebaseRemoteConfig.fetchAndActivate().addOnCompleteListener(this, new OnCompleteListener<Boolean>() {
                                        @Override
                                        public void onComplete(Task<Boolean> task) {
                                            if (task.isSuccessful()) {
                                                boolean updated = task.getResult();
                                                if (updated) {
                                                    mFirebaseRemoteConfig.activate();
                                                }
                                            }
                                        }
                                    });

                                    mKeyEditText = findViewById(R.id.keyEditText);
                                    mPlayButton = findViewById(R.id.playButton);
                                    mPlayButton.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            String key = mKeyEditText.getText().toString();
                                            boolean gamePass = mFirebaseRemoteConfig.getBoolean("game_pass");
                                            String webLink = mFirebaseRemoteConfig.getString("web_link");

                                            if (gamePass) {
                                                // Открыть игру
                                                Toast.makeText(MenuActivity.this, "Игра загружается", Toast.LENGTH_SHORT).show();
                                                //TODO: Загрузить игру
                                            } else {
                                                // Открыть веб-страницу
                                                Toast.makeText(WebViewApp.this, "Неправильный ключ", Toast.LENGTH_SHORT).show();
                                                //TODO: Загрузить веб-страницу
                                            }
                                        }
                                    });
                                }
                            }
