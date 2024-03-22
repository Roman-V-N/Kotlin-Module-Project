
class NotesProg {
    private val archives = mutableListOf<Archive>()
    fun runProg() {
        println("Приложение \"Заметки\" запущено")
        while (true) {
            listMenu(-1)
            val select: Int = inputInt()
            when (select) {
                0 -> {
                    println("<< Работа приложения \"Заметки\" завершена")
                    break
                }
                1 -> createArchive()
                in 2..archives.size + 1 -> selectArchive(select - 2)
                else -> inputError()
            }
        }

    }


    private fun createArchive() {
        print("Введите имя архива: ")
        val archiveName = inputStr()
        val archive = Archive(archiveName, mutableListOf())
        archives.add(archive)
        println("\nСоздан архив: \"$archiveName\"")
    }

    private fun selectArchive(element : Int) {
        while (true) {
            listMenu(element)
            val select: Int = inputInt()
            when (select) {
                0 -> return
                1 -> createNote(element)
                in 2..archives[element].notes.size + 1 -> println(archives[element].notes[select - 2])
                else -> inputError()
            }
        }
    }

    private fun createNote(element : Int) {
        val note: Note = inputNote()
        archives[element].notes.add(note)
        println("\nЗаметка \"${note.nameNote}\" создана.")
    }

    private fun inputNote(): Note {
        val name: String
        val text: String
        print("Введите наименование земетки: ")
        name = inputStr()
        print("Введите текст земетки \"$name\": ")
        text = inputStr()
        return Note(name, text)
    }

    private fun listMenu(element : Int) {
        var menu : String ="\n>> Просмотр архивов "
        if (element >= 0) {
            menu+=">> Архив \"${archives[element].name}\"\nВыберите пункт меню:\n0. Назад\n1. Создать заметку"
            for (i in 0 until archives[element].notes.size) {
                menu+="\n${i + 2}. Заметка \"${archives[element].notes[i].nameNote}\""
            }
        }

        else {
            menu+="\nВыберите пункт меню:\n0. Выйти из программы\n1. Создать архив"
            for (i in 0 until archives.size) {
                menu+="\n${i + 2}. Архив \"${archives[i].name}\""
            }

        }
        print("$menu\n<< ")
    }

}