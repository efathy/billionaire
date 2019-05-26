package me.eslamfathy.billionaire.service;

import me.eslamfathy.billionaire.model.Prize;
import me.eslamfathy.billionaire.model.Question;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class QuestionsGenerator {

    private static QuestionsGenerator questionsGenerator;

    private QuestionsGenerator() {
    }

    public static QuestionsGenerator getInstance() {
        if (questionsGenerator == null) {
            questionsGenerator = new QuestionsGenerator();
        }
        return questionsGenerator;
    }

    public Queue<Question> generate() {
        Queue<Question> questions = new LinkedList<>();

        Question question = new Question();
        question.setStatement(
                "At any one time, what percentage of 5 to 16 year olds in the UK have a mental health problem?");
        question.setChoices(getChoices("1%", "5%", "10%", "20%"));
        question.setCorrectAnswer(3);
        question.setPrize(Prize.A);
        question.setAnswerExplanation(
                "And if you look at the adult population this figure rises to 1 in 4 or 25%. It has been estimated that by 2020 depression will be second only to chronic heart disease as an international health burden.\n" +
                        "In 2007 UNICEF compared children and young people across 18 European countries and North America and children and young people in UK came bottom of the table for wellbeing");
        questions.add(question);

        question = new Question();
        question.setStatement("How many teenagers are believed to self-harm in the UK?");
        question.setChoices(getChoices("1 in 15", "1 in 30", "1 in 50", "1 in 100"));
        question.setCorrectAnswer(1);
        question.setPrize(Prize.B);
        question.setAnswerExplanation(
                "Reports show that 1 in 15 teenagers self harm but the true figure could be even higher. Around 19,000 young people are admitted to hospital for deliberate self harm each year.\n" +
                        "Self harm is a sign of emotional distress. Cutting is one form of self harm. Others include burning, hitting, bruising or poisoning.\n" +
                        "Self harm is more common than most people realise and it affects boys as well as girls. Young people who self harm experience a lot of stigma. They may be bullied as a result which will make them feel even worse. They are also more likely to tell a friend than anyone else so it is important to support your friends and be there for them. If a friend tells you they self harm, don’t be afraid; the best thing you can do is listen. If you feel worried or feel out of your depth ask someone you trust or a professional for advice.");
        questions.add(question);

        question = new Question();
        question.setStatement("Which of these symptoms can happen if you’re depressed?");
        question.setChoices(getChoices("Don’t feel hungry", "Hungry all the time", "Always tired", "Any of above"));
        question.setCorrectAnswer(4);
        question.setPrize(Prize.C);
        question.setAnswerExplanation("");
        questions.add(question);

        question = new Question();
        question.setStatement("Which of these are possible triggers for a psychotic episode?");
        question.setChoices(getChoices("Taking drugs", "Going to school", "Going shopping", "All of above"));
        question.setCorrectAnswer(1);
        question.setPrize(Prize.D);
        question.setAnswerExplanation(
                "Recent research claimed that people using cannabis are 40% more likely than non-users to suffer a psychotic illness such as schizophrenia. The study found the most frequent users of cannabis have twice the risk of non-users of developing psychotic symptoms, such as hallucinations and delusions. They said that people with family history of mental illness or who already had mental health issues should avoid using cannabis.");
        questions.add(question);

        question = new Question();
        question.setStatement(
                "How many murders are committed in England & Wales in one year by people judged to be mentally ill?");
        question.setChoices(getChoices("1555", "555", "55", "5"));
        question.setCorrectAnswer(3);
        question.setPrize(Prize.E);
        question.setAnswerExplanation(
                "Violence can be a feature of mental illness and every year in England and Wales on average 55 people are killed by persons judged to be mentally ill.\n" +
                        "But you are 70 times more likely to be killed on the roads. Indeed the risk of being killed by a mentally ill person is about the same as the risk of being struck by lightning. People with mental illness are far more likely to hurt themselves than someone else.\n" +
                        "Of the 55 people killed in a year by people who were mentally ill only 5 are likely to be strangers. The victims are usually people known to the person.\n" +
                        "You are 9 times more likely to be killed by someone under the influence of drugs or drink - You are at far greater risk from heavy drinkers than they are from the mentally ill. Yet our fear of violence from the mentally ill is disproportionate to the actual risk.\n" +
                        "Why? The media have in the past been intent on stressing the dangers posed by the mentally ill with sensationalist headlines like ‘mad axe man’ etc. And this creates a vicious circle – as people become more fearful so those with mental illness experience more stigma and discrimination adding to the burden they already experience through their mental health condition.\n" +
                        "What can we do? Education - Get the facts about mental health issues and treat those experiencing difficulties with compassion, respect and support not hostility and fear.");
        questions.add(question);

        question = new Question();
        question.setStatement("It is estimated that since 1985 suicide attempts by young men have...");
        question.setChoices(getChoices("Fallen by 17%", "Stayed the same", "Risen by 70%", "Risen by 170%"));
        question.setCorrectAnswer(4);
        question.setPrize(Prize.F);
        question.setAnswerExplanation(
                "Suicide is the second most common cause of death among people under 35 and accounts for 1 in 5 of all deaths of young people.");
        questions.add(question);

        question = new Question();
        question.setStatement("Which of the following people has experienced serious mental health problems?");
        question.setChoices(getChoices("J K Rowling", "Catherine Tate", "Robbie Williams", "All of above"));
        question.setCorrectAnswer(4);
        question.setPrize(Prize.G);
        question.setAnswerExplanation(
                "Many high profile and successful figures in our communities and in the news have mental health issues. Others include Ruby Wax, Steven Fry, Winston Churchill");
        questions.add(question);

        question = new Question();
        question.setStatement("Which of the following are considered to be real medical conditions?");
        question.setChoices(getChoices("Diabetes", "Anxiety disorders", "High blood pressure", "All of above"));
        question.setCorrectAnswer(4);
        question.setPrize(Prize.F);
        question.setAnswerExplanation(
                "Mental health issues and illnesses are just as real as physical illnesses. When they are mild you will often get better on your own the way you might from a cold but if you feel low for more than 2 or 3 weeks and the way you feel starts affecting the rest of your life you may need help. And with the right help you can make a full recovery.");
        questions.add(question);

        return questions;
    }

    private Map getChoices(String... choices) {
        Map<Integer, String> choicesMap = new HashMap<>();
        for (int i = 1; i <= choices.length; i++) {
            choicesMap.put(i, choices[i-1]);
        }
        return choicesMap;
    }
}
