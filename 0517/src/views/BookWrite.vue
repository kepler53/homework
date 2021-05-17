<template lang="">
    <div>
        <h1>이곳은 책 추가 화면입니다.</h1>
        작가 : <input type="text" v-model="book.author"><br>
        내용 : <input type="text" v-model="book.content"><br>
        ISBN : <input type="text" v-model="book.isbn"><br>
        가격 : <input type="text" v-model="book.price"><br>
        제목 : <input type="text" v-model="book.title"><br>
        <button v-on:click="add">작성완료</button>
    </div>
</template>
<script>

import http from "@/util/http-common"

export default {
    data() {
        return {
            book : {
                author : '',
                content : '',
                isbn : '',
                price : 0,
                title : '',
            },
        }
    },
    methods: {
        add(){
            // console.log(this.book);
            http({
                method : 'post',
                url : '/book',
                data : this.book,
            }).then((resp)=>{
                alert(resp.data);
            })
            this.$router.push('/book');
        }
    },

}
</script>
<style lang="">
    
</style>