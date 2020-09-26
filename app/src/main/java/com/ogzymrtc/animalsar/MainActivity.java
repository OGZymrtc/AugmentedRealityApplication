package com.ogzymrtc.animalsar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.Renderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class MainActivity extends AppCompatActivity {

    ArFragment arFragment;
    private ModelRenderable bearRenderable, catRenderable, cowRenderable, dogRenderable, elephantRenderable, ferretRenderable, hippoRenderable,
                            horseRenderable, koalabearRenderable, lionRenderable, reindeerRenderable, wolverineRenderable;
    ImageView bear, cat, cow, dog, elephant, ferret, hippo, horse, koala, lion, reindeer, wolverine;
    View arrayView[];



    int selected = 1; //Default Bear Is Choose
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.sceneform_ux_fragment);

        //View
        bear = findViewById(R.id.bear);
        cat = findViewById(R.id.cat);
        dog = findViewById(R.id.dog);
        cow = findViewById(R.id.cow);
        elephant = findViewById(R.id.elephant);
        ferret = findViewById(R.id.ferret);
        hippo = findViewById(R.id.hippopotamus);
        horse = findViewById(R.id.horse);
        koala = findViewById(R.id.koala_bear);
        lion = findViewById(R.id.lion);
        reindeer = findViewById(R.id.reindeer);
        wolverine = findViewById(R.id.wolverine);

        setArrayView();
        setClickListener();
        setupModel();

        arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {
                //When User Tap On Plane, I Will Add Model
                    Anchor anchor = hitResult.createAnchor();
                    AnchorNode anchorNode = new AnchorNode(anchor);
                    anchorNode.setParent(arFragment.getArSceneView().getScene());
                    createModel(anchorNode, selected);
            }
        });
    }

    private void setupModel() {

        ModelRenderable.builder()
                .setSource(this, R.raw.bear)
                .build().thenAccept(renderable -> bearRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unnable To Load Bear Model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this, R.raw.cat)
                .build().thenAccept(renderable -> catRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unnable To Load Bear Model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this, R.raw.dog)
                .build().thenAccept(renderable -> dogRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unnable To Load Bear Model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this, R.raw.cow)
                .build().thenAccept(renderable -> cowRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unnable To Load Bear Model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this, R.raw.elephant)
                .build().thenAccept(renderable -> elephantRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unnable To Load Bear Model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this, R.raw.ferret)
                .build().thenAccept(renderable -> ferretRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unnable To Load Bear Model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this, R.raw.hippopotamus)
                .build().thenAccept(renderable -> hippoRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unnable To Load Bear Model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this, R.raw.horse)
                .build().thenAccept(renderable -> horseRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unnable To Load Bear Model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this, R.raw.koala_bear)
                .build().thenAccept(renderable -> koalabearRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unnable To Load Bear Model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this, R.raw.lion)
                .build().thenAccept(renderable -> lionRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unnable To Load Bear Model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this, R.raw.reindeer)
                .build().thenAccept(renderable -> reindeerRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unnable To Load Bear Model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this, R.raw.wolverine)
                .build().thenAccept(renderable -> wolverineRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unnable To Load Bear Model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
    }

    private void createModel(AnchorNode anchorNode, int selected) {
        switch (selected){
            case 1: 
                TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
                bear.setParent(anchorNode);
                bear.setRenderable(bearRenderable);
                bear.select();
                addName(anchorNode, bear, "Bear"); 
                break;
            case 2:
                TransformableNode Cat = new TransformableNode(arFragment.getTransformationSystem());
                Cat.setParent(anchorNode);
                Cat.setRenderable(catRenderable);
                Cat.select();
                addName(anchorNode, Cat, "Cat");
                break;
            case 3:
                TransformableNode Dog = new TransformableNode(arFragment.getTransformationSystem());
                Dog.setParent(anchorNode);
                Dog.setRenderable(dogRenderable);
                Dog.select();
                addName(anchorNode, Dog, "Dog");
                break;
            case 4:
                TransformableNode Cow = new TransformableNode(arFragment.getTransformationSystem());
                Cow.setParent(anchorNode);
                Cow.setRenderable(cowRenderable);
                Cow.select();
                addName(anchorNode, Cow, "Cow");
                break;
            case 5:
                TransformableNode Elephant = new TransformableNode(arFragment.getTransformationSystem());
                Elephant.setParent(anchorNode);
                Elephant.setRenderable(elephantRenderable);
                Elephant.select();
                addName(anchorNode, Elephant, "Elephant");
                break;
            case 6:
                TransformableNode Ferret = new TransformableNode(arFragment.getTransformationSystem());
                Ferret.setParent(anchorNode);
                Ferret.setRenderable(ferretRenderable);
                Ferret.select();
                addName(anchorNode, Ferret, "Ferret");
                break;
            case 7:
                TransformableNode Hippopotamus = new TransformableNode(arFragment.getTransformationSystem());
                Hippopotamus.setParent(anchorNode);
                Hippopotamus.setRenderable(hippoRenderable);
                Hippopotamus.select();
                addName(anchorNode, Hippopotamus, "Hippopotamus");
                break;
            case 8:
                TransformableNode Horse = new TransformableNode(arFragment.getTransformationSystem());
                Horse.setParent(anchorNode);
                Horse.setRenderable(horseRenderable);
                Horse.select();
                addName(anchorNode, Horse, "Horse");
                break;
            case 9:
                TransformableNode Koala = new TransformableNode(arFragment.getTransformationSystem());
                Koala.setParent(anchorNode);
                Koala.setRenderable(koalabearRenderable);
                Koala.select();
                addName(anchorNode, Koala, "Koala");
                break;
            case 10:   
                TransformableNode Lion = new TransformableNode(arFragment.getTransformationSystem());
                Lion.setParent(anchorNode);
                Lion.setRenderable(lionRenderable);
                Lion.select();
                addName(anchorNode, Lion, "Lion");
                break;
            case 11:
                TransformableNode Reindeer = new TransformableNode(arFragment.getTransformationSystem());
                Reindeer.setParent(anchorNode);
                Reindeer.setRenderable(reindeerRenderable);
                Reindeer.select();
                addName(anchorNode, Reindeer, "Reindeer");
                break;
            case 12:
                TransformableNode Wolverine = new TransformableNode(arFragment.getTransformationSystem());
                Wolverine.setParent(anchorNode);
                Wolverine.setRenderable(wolverineRenderable);
                Wolverine.select();
                addName(anchorNode, Wolverine, "Wolverine");
                break;
            default: break;
            };
    }

    private void addName(AnchorNode anchorNode, TransformableNode model, String name) {
        //Each Model I Will Create Each Name
        ViewRenderable.builder().setView(this, R.layout.name_animal)
                .build().thenAccept(viewRenderable -> {
            TransformableNode nameView = new TransformableNode(arFragment.getTransformationSystem());
            nameView.setLocalPosition(new Vector3(0f, model.getLocalPosition().y+0.5f, 0));
            nameView.setParent(anchorNode);
            nameView.setRenderable(viewRenderable);
            nameView.select();

            //Set Text
            TextView txt_name = (TextView) viewRenderable.getView();
            txt_name.setText(name);

            //Click To Text View To Remove Animal
            txt_name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    anchorNode.setParent(null);
                }
            });
        });

    }

    private void setClickListener() {
        for (int i=0 ; i<arrayView.length ; i++){
            arrayView[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v.getId() == R.id.bear){
                        selected = 1;
                        setBackground(v.getId());
                    }
                    else if (v.getId() == R.id.cat){
                        selected =2;
                        setBackground(v.getId());
                    }
                    else if (v.getId() == R.id.dog){
                        selected =3;
                        setBackground(v.getId());
                    }
                    else if (v.getId() == R.id.cow){
                        selected =4;
                        setBackground(v.getId());
                    }
                    else if (v.getId() == R.id.elephant){
                        selected =5;
                        setBackground(v.getId());
                    }
                    else if (v.getId() == R.id.ferret){
                        selected =6;
                        setBackground(v.getId());
                    }
                    else if (v.getId() == R.id.hippopotamus){
                        selected =7;
                        setBackground(v.getId());
                    }
                    else if (v.getId() == R.id.horse){
                        selected =8;
                        setBackground(v.getId());
                    }
                    else if (v.getId() == R.id.koala_bear){
                        selected =9;
                        setBackground(v.getId());
                    }
                    else if (v.getId() == R.id.lion){
                        selected =10;
                        setBackground(v.getId());
                    }
                    else if (v.getId() == R.id.reindeer){
                        selected =11;
                        setBackground(v.getId());
                    }
                    else if (v.getId() == R.id.wolverine){
                        selected =12;
                        setBackground(v.getId());
                    }
                }
            });
        }
    }

    private void setBackground(int id) {
        for (int i = 0 ; i<arrayView.length ; i++){
            if (arrayView[i].getId() == id){
                arrayView[i].setBackgroundColor(Color.parseColor("#80333639"));
            }
            else
                arrayView[i].setBackgroundColor(Color.TRANSPARENT);
        }
    }

    private void setArrayView() {
        arrayView = new View[]{
                bear, cat, cow, dog, elephant, ferret, hippo, horse, koala, lion, reindeer, wolverine
        };
    }

}
