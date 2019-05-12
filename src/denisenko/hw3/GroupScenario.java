package denisenko.hw3;


/*
Roles and Replicas
 */
public class GroupScenario {

    public static String printScenario(String[] roles, String[] scenarioPlay) {

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < roles.length; i++) {

            answer.append(roles[i])
                    .append(":")
                    .append("\n")
                    .append(selectScenarioByRole(roles[i], scenarioPlay));
        }

        return answer.toString();
    }

    public static String selectScenarioByRole(String role, String[] scenario) {

        StringBuilder sortScenario = new StringBuilder();

        for (int i = 0; i < scenario.length; i++) {

            if (scenario[i].startsWith(role + ":")) {

                sortScenario.append(i + 1)
                        .append(")")
                        .append(scenario[i].substring(role.length() + 1))
                        .append("\n");
            }
        }

        return sortScenario.toString();
    }

    public static void main(String[] args) {

        String[] roles = {
                "Городничий", "Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич"};
        String[] textLines = {"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие:" +
                " к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};

        System.out.println(printScenario(roles, textLines));
    }

}
