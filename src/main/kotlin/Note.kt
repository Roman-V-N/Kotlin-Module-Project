data class Note (
    val nameNote : String,
    val textNote : String
) {
    override fun toString() = "\nТекст заметки \"$nameNote\": $textNote"
}