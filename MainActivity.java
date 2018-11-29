/*

Team A need to start the match first by Batting First.
If team A got all it's wikets out i.e upto 10 then Team B will start Playing

 */

package com.android.example.cricket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.example.cricket.R;

import org.w3c.dom.Text;

import static com.android.example.cricket.R.id.teamA4Board;
import static com.android.example.cricket.R.id.teamA6Board;
import static com.android.example.cricket.R.id.teamAOutBoard;
import static com.android.example.cricket.R.id.teamAScoreBoard;
import static com.android.example.cricket.R.id.teamASingleBoard;
import static com.android.example.cricket.R.id.teamB4Board;
import static com.android.example.cricket.R.id.teamB6Board;
import static com.android.example.cricket.R.id.teamBOutBoard;
import static com.android.example.cricket.R.id.teamBScoreBoard;
import static com.android.example.cricket.R.id.teamBSingleBoard;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blockerB();

    }

    
    /*CurrentScore -> Total current score of the team.
    TeamPointsBoard -> Board in front of buttons.*/


    int teamACurrentScore = 0, teamBCurrentScore = 0;
    int teamASinglePoint = 0, teamA4Points = 0, teamA6Points = 0, teamAOutPoints = 0;
    int teamBSinglePoints = 0, teamB4Points = 0, teamB6Points = 0, teamBOutPoints = 0;

    public void teamASingle(View v) {
        teamASinglePoint += 1;
        TextView teamASingleBoardS = (TextView) findViewById(R.id.teamASingleBoard);
        teamASingleBoardS.setText("" + teamASinglePoint);
        teamACurrentScore += 1;
        displayTeamAScore(teamACurrentScore);
    }

    public void teamA4(View v) {
        teamA4Points += 1;
        TextView teamA4BoardS = (TextView) findViewById(R.id.teamA4Board);
        teamA4BoardS.setText("" + teamA4Points);
        teamACurrentScore += 4;
        displayTeamAScore(teamACurrentScore);
    }

    public void teamA6(View v) {
        teamA6Points += 1;
        TextView teamA6BoardS = (TextView) findViewById(R.id.teamA6Board);
        teamA6BoardS.setText("" + teamA6Points);
        teamACurrentScore += 6;
        displayTeamAScore(teamACurrentScore);
    }

    public void teamAOut(View v) {
        teamAOutPoints += 1;
        TextView teamAOutBoardS = (TextView) findViewById(R.id.teamAOutBoard);
        teamAOutBoardS.setText("" + teamAOutPoints);
        if(teamAOutPoints == 10) {
            enablerB();
            blockerA();
        }
    }

    public void teamBSingle(View v) {
        teamBSinglePoints += 1;
        TextView teamBSingleBoardS = (TextView) findViewById(R.id.teamBSingleBoard);
        teamBSingleBoardS.setText("" + teamBSinglePoints);
        teamBCurrentScore += 1;
        displayTeamBScore(teamBCurrentScore);
        winAndLoose();
    }

    public void teamB4(View v) {
        teamB4Points += 1;
        TextView teamB4BoardS = (TextView) findViewById(R.id.teamB4Board);
        teamB4BoardS.setText("" + teamB4Points);
        teamBCurrentScore += 4;
        displayTeamBScore(teamBCurrentScore);
        winAndLoose();
    }

    public void teamB6(View v) {
        teamB6Points += 1;
        TextView teamB6BoardS = (TextView) findViewById(R.id.teamB6Board);
        teamB6BoardS.setText("" + teamB6Points);
        teamBCurrentScore += 6;
        displayTeamBScore(teamBCurrentScore);
        winAndLoose();
    }

    public void teamBOut(View v) {
        teamBOutPoints += 1;
        TextView teamBOutBoardS = (TextView) findViewById(R.id.teamBOutBoard);
        teamBOutBoardS.setText("" + teamBOutPoints);
        if(teamBOutPoints >= 10) {
            blockerB();
            looser();
        }
    }

    public void sendScore(View v) {
        String wholeMessage = getString(R.string.team_A) + getString(R.string.score) + " : " + teamACurrentScore + "\n";
        wholeMessage += getString(R.string.single)+ " : " + teamASinglePoint + "\n";
        wholeMessage += getString(R.string.four) + " : " + teamA4Points + "\n";
        wholeMessage += getString(R.string.six) + " : " + teamA6Points + "\n";
        wholeMessage += getString(R.string.wickets) + " : " + teamAOutPoints + "\n";
        wholeMessage += "\n";
        wholeMessage += getString(R.string.team_B) + getString(R.string.score) + " : " + teamBCurrentScore + "\n";
        wholeMessage += getString(R.string.single) + " : " + teamBSinglePoints + "\n";
        wholeMessage +=  getString(R.string.four) + " : " + teamB4Points + "\n";
        wholeMessage += getString(R.string.six) + " : " + teamB6Points + "\n";
        wholeMessage += getString(R.string.wickets) + " : " + teamBOutPoints + "\n";

        //To send the data as a mail.
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Score of Criket Match!");
        intent.putExtra(Intent.EXTRA_TEXT, wholeMessage);
        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /*public void reset(View v) {
        teamACurrentScore = 0;
        displayTeamAScore(teamACurrentScore);
        teamBCurrentScore = 0;
        displayTeamBScore(teamBCurrentScore);
        teamAOutPoints = 0;
        TextView teamAOutBoardS = (TextView) findViewById(R.id.teamAOutBoard);
        teamAOutBoardS.setText("" + teamAOutPoints);
        teamBOutPoints = 0;
        TextView teamBOutBoardS = (TextView) findViewById(R.id.teamBOutBoard);
        teamBOutBoardS.setText("" + teamBOutPoints);
        teamASinglePoint = 0;
        TextView teamASingleBoardS = (TextView) findViewById(R.id.teamASingleBoard);
        teamASingleBoardS.setText("" + teamASinglePoint);
        teamA4Points = 0;
        TextView teamA4BoardS = (TextView) findViewById(R.id.teamA4Board);
        teamA4BoardS.setText("" + teamA4Points);
        teamA6Points = 0;
        TextView teamA6BoardS = (TextView) findViewById(R.id.teamA6Board);
        teamA6BoardS.setText("" + teamA6Points);
        teamBSinglePoints = 0;
        TextView teamBSingleBoardS = (TextView) findViewById(R.id.teamBSingleBoard);
        teamBSingleBoardS.setText("" + teamBSinglePoints);
        teamB4Points = 0;
        TextView teamB4BoardS = (TextView) findViewById(R.id.teamB4Board);
        teamB4BoardS.setText("" + teamB4Points);
        teamB6Points = 0;
        TextView teamB6BoardS = (TextView) findViewById(R.id.teamB6Board);
        teamB6BoardS.setText("" + teamB6Points);
        enablerA();
        blockerB();
    }*/

    private void displayTeamAScore(int score) {
        TextView teamAScoreBoardS = (TextView) findViewById(R.id.teamAScoreBoard);
        teamAScoreBoardS.setText("" + score);
    }

    private void displayTeamBScore(int score) {
        TextView teamBScoreBoardS = (TextView) findViewById(R.id.teamBScoreBoard);
        teamBScoreBoardS.setText("" + score);
    }

    private void blockerA() {
        Button buttonASingle = (Button) findViewById(R.id.teamASingleButton);
        Button buttonA4 = (Button) findViewById(R.id.teamA4Button);
        Button buttonA6 = (Button) findViewById(R.id.teamA6Button);
        Button buttonAOut = (Button) findViewById(R.id.teamAOutButton);
        buttonASingle.setClickable(false);
        buttonA6.setClickable(false);
        buttonA4.setClickable(false);
        buttonAOut.setClickable(false);
    }

    private void blockerB() {
        Button buttonBSingle = (Button) findViewById(R.id.teamBSingleButton);
        Button buttonB4 = (Button) findViewById(R.id.teamB4Button);
        Button buttonB6 = (Button) findViewById(R.id.teamB6Button);
        Button buttonBOut = (Button) findViewById(R.id.teamBOutButton);
        buttonBSingle.setClickable(false);
        buttonB6.setClickable(false);
        buttonB4.setClickable(false);
        buttonBOut.setClickable(false);
    }

    private void enablerA() {
        Button buttonASingle = (Button) findViewById(R.id.teamASingleButton);
        Button buttonA4 = (Button) findViewById(R.id.teamA4Button);
        Button buttonA6 = (Button) findViewById(R.id.teamA6Button);
        Button buttonAOut = (Button) findViewById(R.id.teamAOutButton);
        buttonASingle.setClickable(true);
        buttonA6.setClickable(true);
        buttonA4.setClickable(true);
        buttonAOut.setClickable(true);
    }

    private void enablerB() {
        Button buttonBSingle = (Button) findViewById(R.id.teamBSingleButton);
        Button buttonB4 = (Button) findViewById(R.id.teamB4Button);
        Button buttonB6 = (Button) findViewById(R.id.teamB6Button);
        Button buttonBOut = (Button) findViewById(R.id.teamBOutButton);
        buttonBSingle.setClickable(true);
        buttonB6.setClickable(true);
        buttonB4.setClickable(true);
        buttonBOut.setClickable(true);
    }

    private void winAndLoose() {
        TextView teamAScoreBoardS = (TextView) findViewById(R.id.teamAScoreBoard);
        TextView teamBScoreBoardS = (TextView) findViewById(R.id.teamBScoreBoard);
        int two = Integer.parseInt("" + teamBScoreBoardS.getText());
        int one = Integer.parseInt("" + teamAScoreBoardS.getText());
        if(teamACurrentScore < teamBCurrentScore) {
            blockerA();
            blockerB();
            teamAScoreBoardS.setText("L");
            teamBScoreBoardS.setText("W");
        }
    }

    private void looser() {
        TextView teamAScoreBoardS = (TextView) findViewById(R.id.teamAScoreBoard);
        TextView teamBScoreBoardS = (TextView) findViewById(R.id.teamBScoreBoard);
        //int two = Integer.parseInt("" + teamBScoreBoardS.getText());
        //int one = Integer.parseInt("" + teamAScoreBoardS.getText());
        if(teamACurrentScore > teamBCurrentScore) {
            blockerA();
            blockerB();
            teamAScoreBoardS.setText("W");
            teamBScoreBoardS.setText("L");
        }
        else if(teamACurrentScore == teamBCurrentScore) {
            blockerA();
            blockerB();
            teamAScoreBoardS.setText("D");
            teamBScoreBoardS.setText("D");
        }
    }

}
