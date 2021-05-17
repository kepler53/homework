import Vue from "vue";
import Vuex from "vuex";
import http from "@/util/http-common.js";

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        //실제 저장되는 데이터
        books: [], // 책 목록에서 사용되는 책 여러개 정보
        book: {}, //책 추가할 때나 수정할 때 사용되는 책 한권의 정보
        comments: [], //책 하나에 딸려있는 여러 댓글들
    },
    mutations: {
        //action의 동작이 완료되었으면, 즉 back-end한테 데이터 잘 받아왔으면 그 때 state에 반영
        setBooks(state, payload) {
            state.books = payload;
        },
        setBook() {},
        setComments() {},
    },
    actions: {
        //비동기 요청을 보내면 데이터가 오는 동안 시간이 걸릴 수 있음
        getBooks(context) {
            http({
                method: "get",
                url: "/book",
            }).then((resp) => {
                context.commit("setBooks", resp.data);
            });
        },
        getBook() {},
        getComments() {},
    },
    // modules: { =>사용하지 않고 getters를 사용
    // }
    getters: {
        //직접 접근을 막기 위한
        books(state) {
            return state.books;
        },
        book(state) {
            return state.book;
        },
        comments(state) {
            return state.comments;
        },
    },
});
