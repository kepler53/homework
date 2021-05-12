export default {
    template: `<div>
        제목을 입력하세요   :  <input type="text" v-model="btitle"><br>
        작성자를 입력하세요 :  <input type="text" v-model="bwriter"><br>
        내용을 입력하세요   :  <input type="text" v-model="bcontent"><br>
        <button v-on:click="regist">등록</button>
        
    </div>`,
    data() {
        return {
            btitle: "",
            bwriter: "",
            bcontent: "",
        };
    },
    created() {},
    methods: {
        regist() {
            axios
                .post("http://127.0.0.1:9999/bootboard/board", {
                    btitle: this.btitle,
                    bwriter: this.bwriter,
                    bcontent: this.bcontent,
                })
                .then((res) => {
                    console.log(res.data);
                    bus.$emit("msg", res.data);
                    //이곳에서 날리기
                });
            this.btitle = "";
            this.bwriter = "";
            this.bcontent = "";
            // 이부분에서 오브젝트로 묶어서 보내는 법 알아보기
            //추가되고 나서 새로고침하는 방법 리스트에 반영이 안되므로 list.js에  updated로 넘기기
        },
    },
};
