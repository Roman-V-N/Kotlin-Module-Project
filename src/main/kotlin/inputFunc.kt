import java.util.Scanner
fun inputStr() : String {
    var sc = Scanner(System.`in`)
    var str : String
    do {
        str = sc.nextLine()
        if (str.length==0) inputError()
    } while(str.length==0)
    return str
}

fun inputInt() : Int {
    var sc = Scanner(System.`in`)
    while (!sc.hasNextInt())
    {  inputError()
        sc.next()
    }
    val int : Int = sc.nextInt()
   return int
}

fun inputError() {
    println("\nВведено некорректное значение! Повторите ввод!")
}
