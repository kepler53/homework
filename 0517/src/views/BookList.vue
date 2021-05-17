<template lang="">
    <div>
        <table border = "1" class = "table">
            <tr v-for="(book, index) in books" :key="index">
                <td v-text="book.isbn"></td>
                <td v-text="book.title"></td>
                <td v-text="book.author"></td>
                <td v-text="book.price"></td>
            </tr>
        </table>
        <button v-on:click="addBook">책 추가</button>
    </div>
</template>
<script>
import {mapGetters} from "vuex"; //vuex 저장소에게서 getters 정보만 얻어오면  된다.

export default {
    
    computed : { //현재 컴포넌트가 독립적인 데이터를 유지할 때는 data를 썼으나 지금은 vuex에서 꺼내는 동작이 필요하다.
        ...mapGetters(["books"])
    },
    created() {
        this.$store.dispatch("getBooks");
    },
    methods: {
        addBook(){
            this.$router.push("/book/write");
        }
    },
}
</script>
<style lang="css">
    .table{
        margin: auto;
    }
</style>