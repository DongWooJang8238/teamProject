package org.joonzis.controller;

public class BoardController {

	@Autowired
	public BoardService service;
		
//	 전체 게시글 조회 - 기존 방식
	@GetMapping("/list")
	public String list(Model model, Criteria cri) {
		log.info("list...");
		
		if(cri.getPageNum() == 0 || cri.getAmount() == 0) {
			cri.setPageNum(1);
			cri.setAmount(10);
		}
		
		int total = service.getTotal();
		log.info("total...." + total);
		model.addAttribute("pageMaker", new PageDTO(cri, total));
		model.addAttribute("list", service.getList(cri));
		return "/board/list";
	}
		
		// 게시글 조회
		@GetMapping("/get")
		public String get(@RequestParam("boardno") int boardno, Model model) {
			// 조회수 증가
			service.boardReadCount(boardno);
			
			log.info("get..." + boardno);
			model.addAttribute("vo", service.get(boardno));
			model.addAttribute("likecount", service.getLikeCount(boardno));
			return "/board/get";
		}
		// 게시글 수정, 수정이 완료되면 board/list로 이동
		@PostMapping("/modify")
		public String modify(BoardVO vo) {
			log.info("modify..." + vo);
			service.modify(vo);
			return "redirect:/board/list";
		}
		// modify(수정) 게시글 이동
		@GetMapping("/modify")
		public String modify(@RequestParam("boardno") int boardno, Model model) {
			log.info("modify..." + boardno);
			model.addAttribute("vo", service.get(boardno));
			return "/board/modify";
		}
		// 게시글 삭제
		@PostMapping("/remove")
		public String remove(@RequestParam("boardno") int boardno) {
			log.info("게시글 삭제..." + boardno);
			service.remove(boardno);
			return "redirect:/board/list";
		}
		
		
		// 게시글 등록
		@PostMapping("/register")
		public String register(BoardVO vo, RedirectAttributes rttr) {
			log.info("register.... " + vo);
			log.info("아타치아타치" + vo.getAttachList());
			service.register(vo);
			
			if(vo.getAttachList() != null) {
				vo.getAttachList().forEach(attach -> log.info("아타치이타치" + attach));
			}
			
			rttr.addFlashAttribute("result", "success");
			
			return "redirect:/board/list";
		}
		// 게시글 등록으로 이동
		@GetMapping("/register")
		public String register2() {
			log.info("register2 게시글 등록 이동...");
			return "/board/register";
		}
		
		// 첨부파일 리스트 조회
		@ResponseBody
		@GetMapping(value = "/getAttachList/{boardno}",
					produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public ResponseEntity<List<BoardAttachVO>> getAttachList(@PathVariable("boardno") int boardno){
			log.info("get 게시판 업로드 파일 리스트... " + boardno);
			
			service.getAttachList(boardno).forEach(action -> {
				log.info("업로드" + action);
			});
			
			return new ResponseEntity<List<BoardAttachVO>>(service.getAttachList(boardno), HttpStatus.OK);
		}
}
